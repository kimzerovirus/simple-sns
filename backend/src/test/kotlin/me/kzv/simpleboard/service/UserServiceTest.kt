package me.kzv.simpleboard.service

import me.kzv.simpleboard.entity.enums.SocialType
import me.kzv.simpleboard.entity.user.LocalUser
import me.kzv.simpleboard.entity.user.SocialUser
import me.kzv.simpleboard.repository.UserRepository
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class UserServiceTest {
    @Autowired lateinit var userService: UserService
    @Autowired lateinit var userRepository: UserRepository

    @Test
    fun `로컬 회원가입이 정상적으로 동작하는 경우`() {
        //given
        val email = "zerovirus96@gmail.com"
        val nickname = "userName"
        val password = "password"
        val user = LocalUser(email = email, nickname = nickname, password = password)

        userRepository.save(user)
    }

    @Test
    fun `소셜 회원가입이 정상적으로 동작하는 경우`() {
        //given
        val email = "zerovirus96@gmail.com"
        val nickname = "userName"
        val socialType = SocialType.GOOGLE
        val user = SocialUser(email = email, nickname = nickname, socialType = socialType)

        userRepository.save(user)
    }
}