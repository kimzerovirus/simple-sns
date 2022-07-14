package me.kzv.okvue.web.account;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collections;

@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return accountRepository.findByEmail(email)
                .map(this::createUSerDetails)
                .orElseThrow(() -> new UsernameNotFoundException(email + " (은)는 존재하지 않는 회원입니다."));
    }

    private UserDetails createUSerDetails(Account account) {
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(account.getAuthority());

        return new User(
                String.valueOf(account.getEmail()),
                account.getPassword(),
                Collections.singleton(grantedAuthority)
        );
    }
}
