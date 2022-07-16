package me.kzv.okvue.modules.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ActiveStatus {
    ACTIVE("활성화"),
    DISABLE("비활성화");

    private final String value;
}
