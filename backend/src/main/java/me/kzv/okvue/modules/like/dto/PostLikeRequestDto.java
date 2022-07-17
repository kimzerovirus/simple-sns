package me.kzv.okvue.modules.like.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import me.kzv.okvue.modules.like.LikeType;

@Getter
@NoArgsConstructor
public class PostLikeRequestDto {
    private Long accountIdx;
    private Long postIdx;
    private LikeType like;
}
