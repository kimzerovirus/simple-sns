package me.kzv.board.web.controller.validator

import me.kzv.board.web.controller.dto.SignUpRequest
import org.springframework.validation.Errors
import org.springframework.validation.Validator

class SignUpRequestValidator(

) : Validator {
    override fun supports(clazz: Class<*>): Boolean = clazz.isAssignableFrom(SignUpRequest::class.java)

    override fun validate(target: Any, errors: Errors) {
        TODO("이메일 중복 체크 및 닉네임 중복 체크 로직")
        when {

        }
    }
}