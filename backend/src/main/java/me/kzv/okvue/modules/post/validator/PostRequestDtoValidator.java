package me.kzv.okvue.modules.post.validator;

import lombok.RequiredArgsConstructor;
import me.kzv.okvue.modules.account.AccountRepository;
import me.kzv.okvue.modules.account.dto.SignupRequestDto;
import me.kzv.okvue.modules.post.PostRepository;
import me.kzv.okvue.modules.post.dto.PostRequestDto;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class PostRequestDtoValidator implements Validator {

    private final PostRepository postRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(PostRequestDto.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        PostRequestDto dto = (PostRequestDto) target;
        if (!postRepository.existsById(dto.getId())) {
            errors.rejectValue("id","invalid.id", new Object[]{dto.getId()},"존재하지 않는 글입니다.");
        }
    }
}
