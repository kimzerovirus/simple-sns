package me.kzv.simpleboard.domain.board

import me.kzv.simpleboard.domain.board.entity.Board
import me.kzv.simpleboard.domain.img.UploadImgRepository
import me.kzv.simpleboard.domain.img.entity.BoardImg
import me.kzv.simpleboard.domain.img.entity.ReplyImg
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
import org.springframework.transaction.annotation.Transactional

@Transactional
@SpringBootTest
class BoardServiceTest {
    @Autowired lateinit var boardService: BoardService
    @Autowired lateinit var imgRepository: UploadImgRepository
    @Autowired lateinit var boardRepository: BoardRepository
    @Autowired lateinit var memberRepository: MemberRepository
    @Autowired lateinit var replyRepository: ReplyRepository

    @BeforeEach
    fun create() {
        val member = Member("email@mail.com", "nickname", SocialType.GOOGLE)
        val board = Board("title", "content", member)
        val boardImg = BoardImg(board, "imgNm", "originImgNm", "imgUrl")
        val reply = Reply("reply", board, member, null)
        val replyImg = ReplyImg(board, reply, "imgNm", "originImgNm", "imgUrl")
        memberRepository.save(member)
        boardRepository.save(board)
        imgRepository.save(boardImg)
        replyRepository.save(reply)
        imgRepository.save(replyImg)
    }

    @Test
    fun `getBoardWithReplies 테스트`() {
        //given
        val boardWithReplies = boardService.getBoardWithReplies(1)

        //when

        //then
        assertThat(boardWithReplies.board.title).isEqualTo("title")
        assertThat(boardWithReplies.reply.size).isEqualTo(1)
    }
}