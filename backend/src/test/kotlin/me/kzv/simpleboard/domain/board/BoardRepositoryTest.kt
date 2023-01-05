package me.kzv.simpleboard.domain.board

import jakarta.persistence.EntityNotFoundException
import me.kzv.simpleboard.domain.board.entity.Board
import me.kzv.simpleboard.domain.member.MemberRepository
import me.kzv.simpleboard.domain.member.entity.Member
import me.kzv.simpleboard.domain.member.entity.SocialType
import me.kzv.simpleboard.domain.reply.ReplyRepository
import me.kzv.simpleboard.domain.reply.entity.Reply
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.domain.PageRequest

@SpringBootTest
class BoardRepositoryTest {

    @Autowired lateinit var boardRepository: BoardRepository
    @Autowired lateinit var memberRepository: MemberRepository
    @Autowired lateinit var replyRepository: ReplyRepository

    @BeforeEach
    fun create(){
        val member = memberRepository.save(Member("test", "test", SocialType.NAVER))
        val board = boardRepository.save(Board("test","test123", member))
        replyRepository.save(Reply(board=board, replier = member, content = "test reply1", parenId = null))
        replyRepository.save(Reply(board=board, replier = member, content = "test reply2", parenId = null))
        replyRepository.save(Reply(board=board, replier = member, content = "test reply3", parenId = null))
    }

    @Test
    fun `게시글과 댓글 한번에 리스트로 조회 by querydsl`() {
        val search = boardRepository.search(null, null, PageRequest.of(0, 10))
        println(search.content)
        assertThat(search.content.size).isEqualTo(1)
    }

    @Test
    fun `특정 게시글의 덧글과 게시글 내용 한번에 조회 by querydsl`() {
        val board = boardRepository.getOneWithReplyCount(1) ?: throw EntityNotFoundException()
        print(board)

        assertThat(board.boardId).isEqualTo(1)
        assertThat(board.replyCount).isEqualTo(3)
    }
}