package me.kzv.simpleboard.entity

import jakarta.persistence.EntityManager
import jakarta.persistence.EntityNotFoundException
import me.kzv.simpleboard.entity.enums.ActiveStatus
import me.kzv.simpleboard.entity.user.User
import me.kzv.simpleboard.entity.user.createLocalUser
import me.kzv.simpleboard.repository.BoardRepository
import me.kzv.simpleboard.repository.UserRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.transaction.annotation.Transactional

@Transactional
@SpringBootTest
class BoardTest {

    @Autowired lateinit var boardRepository: BoardRepository
    @Autowired lateinit var userRepository: UserRepository

    @Test
    fun `게시글 엔티티 저장 테스트`() {
        //given
        val writer = userRepository.save(createLocalUser())
        val board = createBoard(writer = writer)

        //when
        val savedBoard = boardRepository.save(board)

        //then
        val findBoard = boardRepository.findByIdOrNull(savedBoard.id!!) ?: throw EntityNotFoundException()

        assertThat(findBoard.title).isEqualTo("게시글 테스트")
        assertThat(findBoard.imgs[0].imgName).isEqualTo("이미지1")
        assertThat(findBoard.imgs.size).isEqualTo(2)
    }
}

fun createBoard(
    title: String = "게시글 테스트",
    content: String = "게시글 내용",
    writer: User,
): Board {
    val imgs: MutableList<BoardImg> = mutableListOf()
    imgs.add(BoardImg("이미지1", "amazon.s3.com/uuid1"))
    imgs.add(BoardImg("이미지2", "amazon.s3.com/uuid2"))

    return Board(
        title = title,
        content = content,
        imgs = imgs,
        writer = writer,
    )
}