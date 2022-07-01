package me.kzv.okvue.security.oauth2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.kzv.okvue.web.account.persistence.Account;
import me.kzv.okvue.web.account.persistence.LoginType;
import me.kzv.okvue.web.account.persistence.Role;

import java.util.Map;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class OAuth2Attributes {
    private Map<String, Object> attributes;
    private String nameAttributeKey;
    private String nickname;
    private String email;
    private String profileImage;
    private LoginType loginType;

    public Account toEntity(){
        return Account.builder()
                .nickname(nickname)
                .email(email)
                .profileImage(profileImage)
                .role(Role.GUEST) //처음 가입한 유저는 guest로 부여한다.
                .loginType(loginType)
                .build();
    }

    public static OAuth2Attributes of(String registrationId, String userNameAttributeName, Map<String, Object> attributes) {
        switch (registrationId){
            case "google":
                return ofGoogle(userNameAttributeName, attributes);
            case "naver":
                return ofNaver("id", attributes);
            case "kakao":
                return ofKakao("id", attributes);

            default:
                // 소셜플랫폼 아이디가 없는 경우 예외 발생
                throw new RuntimeException("OAuth2 Login Failed");
        }
    }

    private static OAuth2Attributes ofGoogle(String userNameAttributeName, Map<String, Object> attributes) {
        return OAuth2Attributes.builder()
                .nickname((String) attributes.get("name"))
                .email((String) attributes.get("email"))
                .profileImage((String) attributes.get("picture"))
                .loginType(LoginType.GOOGLE)
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    private static OAuth2Attributes ofNaver(String userNameAttributeName, Map<String, Object> attributes) {
        Map<String, Object> response = (Map<String, Object>) attributes.get("response");

        return OAuth2Attributes.builder()
                .nickname((String) response.get("name"))
                .email((String) response.get("email"))
                .profileImage((String) response.get("profile_image"))
                .loginType(LoginType.NAVER)
                .attributes(response)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    private static OAuth2Attributes ofKakao(String userNameAttributeName, Map<String, Object> attributes) {
        Map<String, Object> response = (Map<String, Object>) attributes.get("kakao_account");
        Map<String, Object> responseImage = (Map<String, Object>) response.get("profile");

        return OAuth2Attributes.builder()
                .nickname((String) response.get("nickname"))
                .email((String) response.get("email"))
                .profileImage((String) responseImage.get("profile_image_url"))
                .loginType(LoginType.KAKAO)
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

}
