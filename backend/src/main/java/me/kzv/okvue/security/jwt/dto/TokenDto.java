package me.kzv.okvue.security.jwt.dto;

import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;
import me.kzv.okvue.web.account.persistence.Role;

@ToString
@NoArgsConstructor
public class TokenDto {
    private String email;
    private String nickname;
    private String role;

    @Builder
    public TokenDto(String email, String nickname, String role) {
        this.email = email;
        this.nickname = nickname;
        this.role = role;
    }
}
