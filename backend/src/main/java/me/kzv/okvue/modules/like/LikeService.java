package me.kzv.okvue.modules.like;

import lombok.RequiredArgsConstructor;
import me.kzv.okvue.modules.like.dto.PostLikeRequestDto;
import me.kzv.okvue.modules.post.PostRepository;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LikeService {

    private final PostLikeRepository postLikeRepository;
    private final PostRepository postRepository;

    public int toggleLike(PostLikeRequestDto dto){
        return 0;
    }
}
