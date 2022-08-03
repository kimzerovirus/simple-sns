package me.kzv.okvue.modules.post;

import lombok.RequiredArgsConstructor;
import me.kzv.okvue.infra.common.dto.PageRequestDto;
import me.kzv.okvue.infra.common.dto.PageResponseDto;
import me.kzv.okvue.modules.post.dto.PostRequestDto;
import me.kzv.okvue.modules.post.dto.PostResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1/post")
@RequiredArgsConstructor
@RestController
public class PostController {

    private final PostService postService;

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody PostRequestDto dto){
        Long result = postService.register(dto);

        return ResponseEntity.ok(result);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        PostResponseDto dto = postService.get(id);

        return ResponseEntity.ok(dto);
    }

    @PostMapping("/list")
    public ResponseEntity list(@RequestBody PageRequestDto dto) {
        PageResponseDto result = postService.getListByType(dto);

        return ResponseEntity.ok(result);
    }
}
