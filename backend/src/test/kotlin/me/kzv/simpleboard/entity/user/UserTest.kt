package me.kzv.simpleboard.entity.user

import jakarta.persistence.EntityManager
import jakarta.persistence.EntityNotFoundException
import me.kzv.simpleboard.entity.enums.SocialType
import me.kzv.simpleboard.repository.UserRepository
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
        val newUser = createLocalUser()

        userRepository.save(newUser)
        em.flush()
        em.clear()

        val user: User = userRepository.findByIdOrNull(newUser.id) ?: throw EntityNotFoundException()
        println("유저이름 - " + user.createdBy)
        println("생성날짜 - " + user.createdAt)
    }
}

fun createLocalUser(email: String = "zerovirus96@gmail.com", nickname: String = "gosu", password: String = "1234"): User {
    return LocalUser(email = email, nickname = nickname, password = password)
}

fun createSocialUser(email: String = "zerovirus96@gmail.com", nickname: String = "gosu", socialType: SocialType = SocialType.GOOGLE): User {
    return SocialUser(email = email, nickname = nickname, socialType = socialType)
}
