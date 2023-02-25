package me.kzv.simpleboard.service

import me.kzv.simpleboard.fixture.UserFixture
import me.kzv.simpleboard.repository.UserRepository
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class UserServiceTest {
    @Autowired lateinit var userService: UserService
    @Autowired lateinit var userRepository: UserRepository

    @Test
    fun `회원가입이 정상적으로 동작하는 경우`() {
        //given
        val email = "userName"
        val password = "password"
        val fixture = UserFixture.get()
    }
}