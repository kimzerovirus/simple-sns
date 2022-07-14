package me.kzv.okvue.infra.security.oauth2;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import me.kzv.okvue.web.account.Account;
import me.kzv.okvue.web.account.AccountRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Log4j2
@RequiredArgsConstructor
@Service
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    private final AccountRepository accountRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

        log.info("oauth2");

        OAuth2UserService<OAuth2UserRequest, OAuth2User> delegate = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = delegate.loadUser(userRequest);

        // 현재 로그인하는 소셜 플랫폼 id
        String socialPlatformId = userRequest.getClientRegistration().getRegistrationId();
        String userNameAttributeName = userRequest.getClientRegistration().getProviderDetails().getUserInfoEndpoint().getUserNameAttributeName();

        OAuth2Attributes attributes = OAuth2Attributes.of(socialPlatformId, userNameAttributeName, oAuth2User.getAttributes());
        Account account = getAccount(attributes);
        log.info(account);

        return new DefaultOAuth2User(Collections.singleton(new SimpleGrantedAuthority(account.getRoleKey())),
                attributes.getAttributes(),
                attributes.getNameAttributeKey());
    }

    private Account getAccount(OAuth2Attributes attributes) {

        Optional<Account> account = accountRepository.findByEmail(attributes.getEmail());

        if (account.isPresent()){
            // profile 업데이트 할 경우
//            Account updateAccount = account.get().updateProfile(attributes.getProfileImage());
//            return accountRepository.save(updateAccount);
            // 업데이트 안하고 그냥 반환할 경우
            return account.get();
        } else {
            // 소셜 아이디로 처음 로그인 할 경우
            return accountRepository.save(attributes.toEntity());
        }
    }

//
//    private Account saveAccount(OAuth2Attributes attributes) {
//        return accountRepository.save(attributes.toEntity());
//    }
//
//    private Account updateAccount(OAuth2Attributes attributes) {
//        Account account = accountRepository.findByEmail(attributes.getEmail()).map(entity -> entity.updateProfile(attributes.getProfileImage())).orElse(attributes.toEntity());
//
//        return accountRepository.save(account);
//    }
}
