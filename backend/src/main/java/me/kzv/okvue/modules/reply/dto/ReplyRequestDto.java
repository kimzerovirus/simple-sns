package me.kzv.okvue.modules.reply.dto;

import lombok.Getter;

@Getter
public class ReplyRequestDto {
    private Long commenterId;
    private String comment;
}
