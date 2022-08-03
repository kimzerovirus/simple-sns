package me.kzv.okvue.modules.post;

import lombok.RequiredArgsConstructor;
import me.kzv.okvue.infra.common.dto.PageRequestDto;
import me.kzv.okvue.infra.common.dto.PageResponseDto;
import me.kzv.okvue.modules.post.dto.PostRequestDto;
import me.kzv.okvue.modules.post.dto.PostResponseDto;
import me.kzv.okvue.infra.common.entity.ActiveStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

        // TODO 글 번호를 리턴하여 작성한 글 위치로 이동한다. http://~/free/{id}
        return post.getId();
    }

    // 게시물 한 건 가져오기
    @Transactional(readOnly = true)
    public PostResponseDto get(Long id) {
        Optional<Post> isPost = postRepository.findById(id);
        if(!isPost.isPresent()) return null; // TODO EXCEPTION

        Post post = isPost.get();
        post.updateViewCount(); // 조회수 증가

        return entityToDto(post);
    }

    // 게시물 수정
    @Transactional
    public void modify(PostRequestDto dto) {
        Optional<Post> isPost = postRepository.findById(dto.getId());
        if(isPost.isPresent()) {
            Post post = isPost.get();
            post.update(dto.getTitle(), dto.getContent());
        }
    }

    // 게시물 감추기
    @Transactional
    public void hidden(Long id) {
        Optional<Post> isPost = postRepository.findById(id);
        if(isPost.isPresent()) {
            Post post = isPost.get();
            post.updateStatus(ActiveStatus.DISABLE);
        }
    }

    @Transactional
    public void remove(Long id) {
        // 1. 댓글 삭제

        // 2. 게시물 삭제
        postRepository.deleteById(id); // long 1 반환?
    }

    @Transactional(readOnly = true)
    public PageResponseDto getListByType(PageRequestDto dto) {
        String type = dto.getType();
        PageRequest pageRequest = PageRequest.of(dto.getPage(), dto.getSize(), Sort.by(Sort.Order.desc("id")));

        Page<Post> page = postRepository.findByType(type, pageRequest);

        return new PageResponseDto(page);
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
                .id(entity.getId())
                .title(entity.getTitle())
                .content(entity.getContent())
                .build();
    }

}
