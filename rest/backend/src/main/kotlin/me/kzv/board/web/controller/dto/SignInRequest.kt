package me.kzv.board.web.controller.dto

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken

data class SignInRequest(
    val email: String,
    val password: String
) {
    // 로그인 검증을 스프링 시큐리티에 맡긴다.
    fun toAuthentication(): UsernamePasswordAuthenticationToken = UsernamePasswordAuthenticationToken(email, password)
}

/*
    스프링 시큐리티 기본 전략
    request
    -> UsernamePasswordAuthenticationFilter
    -> Authentication(Username + Password)
    -> AuthenticationManager (인증)
    -> 통과시 Authentication(User + Authorities)를 SecurityContext 에 저장

    이 SecurityContext 는 쓰레드로컬에 저장되어 전역에서 참조가 가능하다고 한다
 */