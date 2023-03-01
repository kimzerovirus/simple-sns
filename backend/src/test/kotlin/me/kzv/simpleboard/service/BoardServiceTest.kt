package me.kzv.simpleboard.service

import me.kzv.simpleboard.entity.Board
import me.kzv.simpleboard.entity.user.createLocalUser
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional

@Transactional
@SpringBootTest
class BoardServiceTest {

    @Autowired lateinit var boardService: BoardService

    @Test
    fun `게시글 등록`() {
        //given
        val title = "새로운 게시글 작성"
        val content = "게시글 테스트"
        val user = createLocalUser()
        val board = Board(title = title, content = content, user = user)

        //when
        val savedBoard = boardService.register(board)

        //then
        assertThat(savedBoard.title).isEqualTo(title)
        assertThat(savedBoard.content).isEqualTo(content)
        assertThat(savedBoard.user).isEqualTo(user)
    }
}