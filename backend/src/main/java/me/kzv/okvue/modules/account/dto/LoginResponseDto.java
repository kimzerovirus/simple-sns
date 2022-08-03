package me.kzv.okvue.modules.account.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import me.kzv.okvue.modules.account.Account;

@NoArgsConstructor
@AllArgsConstructor
public class LoginResponseDto {
    private Long accountId;
    private String email;
    private String nickname;

    public static LoginResponseDto of(Account account) {
        return new LoginResponseDto(account.getId(), account.getEmail(), account.getNickname());
    }
}
