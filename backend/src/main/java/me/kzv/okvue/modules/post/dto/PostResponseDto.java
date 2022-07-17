package me.kzv.okvue.modules.post.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostResponseDto {
    private Long idx;
    private String title;
    private String content;
    private String writer;
    private Long writerIdx;
}
