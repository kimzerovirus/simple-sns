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
import org.springframework.transaction.annotation.Transactional

@Transactional
@SpringBootTest
class UploadImgRepositoryTest {

    @Autowired lateinit var imgRepository: UploadImgRepository
    @Autowired lateinit var boardRepository: BoardRepository
    @Autowired lateinit var memberRepository: MemberRepository
    @Autowired lateinit var replyRepository: ReplyRepository

    var savedBoard: Board? = null
    var savedReply: Reply? = null

    @BeforeEach
    fun create() {
        val member = Member("email@mail.com", "nickname", SocialType.GOOGLE)
        val board = Board("title", "content", member)
        val boardImg = BoardImg(board, "imgNm", "originImgNm", "imgUrl")
        val reply = Reply("reply", board, member, null)
        val replyImg = ReplyImg(board, reply, "imgNm", "originImgNm", "imgUrl")
        memberRepository.save(member)
        savedBoard = boardRepository.save(board)
        imgRepository.save(boardImg)

        savedReply = replyRepository.save(reply)
        imgRepository.save(replyImg)
    }

    @Test
    fun `게시글 업로드 이미지 가져오기 - 단방향`() {
        val boardImg = imgRepository.getBoardImgsByBoardId(savedBoard?.id!!)
        val replyImg = imgRepository.getReplyImgsByBoardId(savedReply?.id!!)

        val results = imgRepository.getImgsByBoardId(savedBoard?.id!!)

        for (result in results) {
            println(result)
        }

        assertThat(boardImg.size).isEqualTo(1)
        assertThat(replyImg.size).isEqualTo(1)

        for (img in replyImg) {
            println(img.reply.id)
        }
//        val test = imgRepository.test(savedBoard!!)
        /**
         * Hibernate: select u1_0.id, u1_0.img_url from (select * from upload_img t where t.img_type='BOARD') u1_0 where u1_0.board_id=?
         * Hibernate: select u1_0.id, u1_0.img_url from (select * from upload_img t where t.img_type='REPLY') u1_0 where u1_0.reply_id=?
         * Hibernate: select u1_0.id, u1_0.img_url from (select * from upload_img t where t.img_type in ('BOARD', 'REPLY')) u1_0 where u1_0.board_id=? or u1_0.board_id=?
         */
    }
}