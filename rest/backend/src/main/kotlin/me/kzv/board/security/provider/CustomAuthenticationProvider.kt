package me.kzv.board.security.provider

import me.kzv.board.security.service.CustomUserDetailsService
import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.core.Authentication
import org.springframework.security.crypto.password.PasswordEncoder

class CustomAuthenticationProvider(
    private val customUserDetailsService: CustomUserDetailsService,
    private val passwordEncoder: PasswordEncoder,
) : AuthenticationProvider {

    override fun authenticate(authentication: Authentication): Authentication {
        TODO("Not yet implemented")
//        if (!passwordEncoder.matches(password, accountContext.getPassword())) {
//            throw BadCredentialsException("비밀번호가 일치하지 않습니다.")
//        }

//        if(!user.isEnabled()) {
//            throw BadCredentialsException("${username}은 탈퇴 또는 정지 회원입니다.")
//        }

    }

    override fun supports(authentication: Class<*>): Boolean {
        TODO("Not yet implemented")
    }
}