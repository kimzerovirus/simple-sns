package me.kzv.okvue.modules.account.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.kzv.okvue.modules.account.Account;
import me.kzv.okvue.modules.account.LoginType;
import me.kzv.okvue.modules.account.Authority;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SignupRequestDto {

    private String email;
    private String nickname;
    private String password;

    public Account toAccount(PasswordEncoder passwordEncoder) {
        return Account.builder()
                .email(email)
                .nickname(nickname)
                .password(passwordEncoder.encode(password))
                .loginType(LoginType.LOCAL)
//                .authority(Authority.GUEST) //처음 가입한 유저는 guest로 부여한다. // 생성자에서 default 초기값 설정
                .build();
    }
}
