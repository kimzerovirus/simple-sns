package me.kzv.simpleboard.domain.img

import me.kzv.simpleboard.domain.board.BoardRepository
import me.kzv.simpleboard.domain.board.entity.Board
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

@SpringBootTest
class UploadImgRepositoryTest {

    @Autowired
    lateinit var imgRepository: UploadImgRepository
    @Autowired
    lateinit var boardRepository: BoardRepository
    @Autowired
    lateinit var memberRepository: MemberRepository
    @Autowired
    lateinit var replyRepository: ReplyRepository

    var savedBoard: Board? = null
    var savedReply: Reply? = null

    @BeforeEach
    fun create() {
        val member = Member("email@mail.com", "nickname", SocialType.GOOGLE)
        val board = Board("title", "content", member)
        val boardImg = BoardImg(board, "imgNm", "originImgNm", "imgUrl")
        val reply = Reply("reply", board, member, null)
        val replyImg = ReplyImg(reply, "imgNm", "originImgNm", "imgUrl")
        memberRepository.save(member)
        savedBoard = boardRepository.save(board)
        imgRepository.save(boardImg)

        savedReply = replyRepository.save(reply)
        imgRepository.save(replyImg)
    }

    @Test
    fun `게시글 업로드 이미지 가져오기`() {
        val boardImg = imgRepository.getImgsByBoard(savedBoard!!)
        val replyImg = imgRepository.getImgsByReply(savedReply!!)

        assertThat(boardImg.size).isEqualTo(1)
        assertThat(replyImg.size).isEqualTo(1)
//        val test = imgRepository.test(savedBoard!!)
//        println(test[0].toString())
    }
}