package me.kzv.okvue.modules.account.dto;

import lombok.Getter;
import me.kzv.okvue.modules.account.Account;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

@Getter
public class CustomUserDetails implements OAuth2User, UserDetails {

    private Account account;
    private Map<String, Object> attributes;

    // 일반 시큐리티 로그인시 사용
    public CustomUserDetails(Account user) {
        this.account = user;
    }

    // OAuth2.0 로그인시 사용
    public CustomUserDetails(Account account, Map<String, Object> attributes) {
        this.account = account;
        this.attributes = attributes;
    }

    public Account getUser() {
        return account;
    }

    @Override
    public String getPassword() {
        return account.getPassword();
    }

    @Override
    public String getUsername() {
        return account.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collet = new ArrayList<GrantedAuthority>();
        collet.add(()->{ return account.getAuthority();});
        return collet;
    }

    // 리소스 서버로 부터 받는 회원정보
    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }

    // Account 의 PK
    @Override
    public String getName() {
        return account.getId().toString();
    }
}
