package me.kzv.board.web.service

import me.kzv.board.web.controller.dto.SignInRequest
import me.kzv.board.web.controller.dto.SignUpRequest
import me.kzv.board.web.domain.Member
import me.kzv.board.web.domain.MemberRepository
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class MemberService(
    private val memberRepository: MemberRepository,
    private val passwordEncoder: PasswordEncoder,
    private val authenticationManagerBuilder: AuthenticationManagerBuilder,
) {

    @Transactional
    fun signUp(dto: SignUpRequest): Member{
        val member = Member.createMember(dto, passwordEncoder)

        return memberRepository.save(member)
    }

    @Transactional(readOnly = true)
    fun signIn(dto: SignInRequest){
        val authenticationToken = dto.toAuthentication()
        val authentication = authenticationManagerBuilder.`object`.authenticate(authenticationToken)

    }
}