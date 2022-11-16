package me.kzv.simpleboardmvc.web.entity.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SocialType {
    LOCAL("일반"),
    GOOGLE("구글"),
    NAVER("네이버"),
    KAKAO("카카오");

    private final String value;
}
