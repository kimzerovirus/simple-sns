package me.kzv.simpleboard.domain.board

import jakarta.persistence.EntityNotFoundException
import me.kzv.simpleboard.domain.board.entity.Board
import me.kzv.simpleboard.domain.img.UploadImgRepository
import me.kzv.simpleboard.domain.img.entity.BoardImg
import me.kzv.simpleboard.domain.member.MemberRepository
import me.kzv.simpleboard.domain.member.entity.Member
import me.kzv.simpleboard.domain.member.entity.SocialType
import me.kzv.simpleboard.domain.reply.ReplyRepository
import me.kzv.simpleboard.domain.reply.entity.Reply
import me.kzv.simpleboard.domain.tag.TagRepository
import me.kzv.simpleboard.domain.tag.entity.Tag
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.domain.PageRequest
import org.springframework.transaction.annotation.Transactional

@Transactional
@SpringBootTest
class BoardRepositoryTest {

    @Autowired lateinit var boardRepository: BoardRepository
    @Autowired lateinit var memberRepository: MemberRepository
    @Autowired lateinit var replyRepository: ReplyRepository
    @Autowired lateinit var imgRepository: UploadImgRepository
    @Autowired lateinit var tagRepository: TagRepository

    @BeforeEach
    fun create() {
        val member = memberRepository.save(Member("test", "test", SocialType.NAVER))
        val tag = tagRepository.save(Tag("해시태그"))
        val createBoard = Board("test", "test123", member)
        createBoard.addTag(tag)
        val board = boardRepository.save(createBoard)
        val boardImg = BoardImg(board, "imgNm", "originImgNm", "imgUrl")

        replyRepository.save(Reply(board = board, replier = member, content = "test reply1", parenId = null))
        replyRepository.save(Reply(board = board, replier = member, content = "test reply2", parenId = null))
        replyRepository.save(Reply(board = board, replier = member, content = "test reply3", parenId = null))
        imgRepository.save(boardImg)
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

    @Test
    fun `findAll EntityGraph 테스트`() {
        val list = boardRepository.findAll()
        for (board in list) {
            println(board.title)
            for (tag in board.tags) {
                println(tag.name)
            }
        }
    }
}