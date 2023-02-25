package me.kzv.simpleboard.entity.user

import jakarta.persistence.EntityManager
import jakarta.persistence.EntityNotFoundException
import me.kzv.simpleboard.fixture.UserFixture
import me.kzv.simpleboard.repository.UserRepository
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.transaction.annotation.Transactional


@Transactional
@SpringBootTest
class UserTest{

    @Autowired lateinit var userRepository: UserRepository
    @Autowired lateinit var em: EntityManager

    @Test
    fun auditingTest() {
        val newUser = UserFixture.get()

        userRepository.save(newUser)
        em.flush()
        em.clear()

        val user: User = userRepository.findByIdOrNull(newUser.id) ?: throw EntityNotFoundException()
        println("유저이름 - " + user.createdBy)
        println("생성날짜 - " + user.createdAt)
    }
}
