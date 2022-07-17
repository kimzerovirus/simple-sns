package me.kzv.okvue.modules.post;

import lombok.RequiredArgsConstructor;
import me.kzv.okvue.modules.post.dto.PostRequestDto;
import me.kzv.okvue.modules.post.dto.PostResponseDto;
import me.kzv.okvue.infra.common.ActiveStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    // 게시물 등록
    @Transactional
    public Long register(PostRequestDto dto) {
        Post post = dtoToEntity(dto);
        postRepository.save(post);

        // TODO 글 번호를 리턴하여 작성한 글 위치로 이동한다. http://~/free/{idx}
        return post.getIdx();
    }

    // 게시물 한 건 가져오기
    @Transactional
    public PostResponseDto get(Long idx) {
        Optional<Post> isPost = postRepository.findById(idx);
        if(!isPost.isPresent()) return null;

        Post post = isPost.get();
        post.updateViewCount(); // 조회수 증가

        return entityToDto(post);
    }

    // 게시물 수정
    @Transactional
    public void modify(PostRequestDto dto) {
        Optional<Post> isPost = postRepository.findById(dto.getIdx());
        if(isPost.isPresent()) {
            Post post = isPost.get();
            post.update(dto.getTitle(), dto.getContent());
        }
    }

    // 게시물 감추기
    @Transactional
    public void hidden(Long idx) {
        Optional<Post> isPost = postRepository.findById(idx);
        if(isPost.isPresent()) {
            Post post = isPost.get();
            post.updateStatus(ActiveStatus.DISABLE);
        }
    }

    @Transactional
    public void remove(Long idx) {
        // 1. 댓글 삭제

        // 2. 게시물 삭제
        postRepository.deleteById(idx); // long 1 반환?
    }



    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



    private Post dtoToEntity(PostRequestDto dto){
        return Post.builder()
                .type(dto.getType())
                .content(dto.getContent())
                .title(dto.getTitle())
//                .writer(Account.builder().idx(dto.getWriterIdx()).build())
                .build();
    }

    private PostResponseDto entityToDto(Post entity) {
        return PostResponseDto.builder()
                .idx(entity.getIdx())
                .title(entity.getTitle())
                .content(entity.getContent())
                .build();
    }
}
