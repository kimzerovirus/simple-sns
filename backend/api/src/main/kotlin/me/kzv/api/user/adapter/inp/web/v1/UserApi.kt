package me.kzv.api.user.adapter.inp.web.v1

import jakarta.validation.Valid
import me.kzv.api.user.adapter.inp.web.v1.req.UserCreateReq
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/users")
class UserApi {
    @PostMapping
    fun create(@RequestBody @Valid req: UserCreateReq) {

    }
}