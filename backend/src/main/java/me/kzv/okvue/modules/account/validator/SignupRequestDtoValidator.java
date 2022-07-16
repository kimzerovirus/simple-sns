package me.kzv.okvue.web.account.validator;

import lombok.RequiredArgsConstructor;
import me.kzv.okvue.web.account.AccountRepository;
import me.kzv.okvue.web.account.dto.SignupRequestDto;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class SignupRequestDtoValidator implements Validator {

    private final AccountRepository accountRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(SignupRequestDto.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        // 이메일 중복체크
        SignupRequestDto dto = (SignupRequestDto) target;
        if (accountRepository.existsByEmail(dto.getEmail())) {
            errors.rejectValue("email","invalid.email", new Object[]{dto.getEmail()},"이미 사용중인 이메일입니다.");
        }
        if (accountRepository.existsByNickname(dto.getNickname())) {
            errors.rejectValue("nickname","invalid.nickname", new Object[]{dto.getNickname()},"이미 사용중인 닉네임입니다.");
        }
    }
}
