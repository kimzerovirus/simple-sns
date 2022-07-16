package me.kzv.okvue.web.account;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {

    ADMIN("ROLE_ADMIN","관리자"),
    GUEST("ROLE_GUEST","손님"), // 이메일 인증을 받지 않은 회원
    USER("ROLE_USER", "일반 사용자"); // 이메일 인증을 받은 회원

    private final String key;
    private final String title;
}