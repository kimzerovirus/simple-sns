package me.kzv.okvue.modules.comment.dto;

import lombok.Getter;

@Getter
public class CommentRequestDto {
    private Long commenterIdx;
    private String comment;
}
