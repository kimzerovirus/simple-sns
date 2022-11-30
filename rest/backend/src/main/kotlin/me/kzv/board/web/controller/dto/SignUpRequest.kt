package me.kzv.board.web.controller.dto

import me.kzv.board.web.domain.Member
import org.hibernate.validator.constraints.Length
import org.springframework.security.crypto.password.PasswordEncoder
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotEmpty

data class SignUpRequest(
    @field:NotBlank(message = "이메일은 필 수 입력 값입니다.")
    @field:Email(message = "이메일 형식으로 입력해주세요.")
    val email: String,

    @field:NotBlank(message = "닉네임은 필 수 입력 값입니다.")
    @field:Length(min = 2, max = 8, message = "닉네임은 2자 이상, 8자 이하로 입력해주세요.")
    val nickname: String,

    @field:NotEmpty(message = "비밀번호는 필수 입력 값입니다.")
    @field:Length(min = 8, max = 16, message = "비밀번호는 8자 이상, 16자 이하로 입력해주세요.")
    val password: String,
)
