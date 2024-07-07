package me.kzv.api.user.adapter.inp.web.v1.req

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotBlank

class UserCreateReq(
    @field:NotBlank
    @field:Email
    val email: String,

    @field:NotBlank
    val password: String,

    @field:NotBlank
    val name: String,
) {

}