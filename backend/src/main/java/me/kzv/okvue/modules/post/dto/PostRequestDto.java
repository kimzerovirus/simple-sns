package me.kzv.okvue.modules.post.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import me.kzv.okvue.modules.post.PostType;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostRequestDto {
    private Long id;
    private PostType type;
    private String title;
    private String content;
    private Long writerId;
}
