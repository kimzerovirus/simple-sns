package me.kzv.simpleboard.domain.board

import jakarta.persistence.EntityNotFoundException
import me.kzv.simpleboard.domain.board.entity.Board
import me.kzv.simpleboard.domain.board.entity.SearchType
import me.kzv.simpleboard.domain.member.MemberRepository
import me.kzv.simpleboard.domain.PageDto
import me.kzv.simpleboard.domain.reply.ReplyRepository
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional(readOnly = true)
@Service
class BoardService(
    private val boardRepository: BoardRepository,
    private val memberRepository: MemberRepository,
    private val replyRepository: ReplyRepository,
) {

    @Transactional
    fun register(memberId: Long, title: String, content: String): Long {
        val writer = memberRepository.findByIdOrNull(memberId) ?: throw EntityNotFoundException()
        val board = boardRepository.save(Board(title = title, content = content, writer = writer))
        return board.id!! // TODO 글번호를 리턴하여 글 등록 후 등록된 게시글로 이동
    }

    fun getList(keyword: String = "", searchType: SearchType?, pageable: Pageable): PageDto {
        return when (searchType) {
                SearchType.TITLE -> PageDto(boardRepository.findByTitleContaining(keyword, pageable))
                SearchType.NICKNAME -> PageDto(boardRepository.findByWriter_NicknameContaining(keyword, pageable))
                SearchType.CONTENT -> PageDto(boardRepository.findByContentContaining(keyword, pageable))
//                SearchType.HASHTAG -> PageDto(boardRepository.findByHashTag(keyword, pageable))
                else -> PageDto(boardRepository.findAll(pageable))
            }
    }

    fun getListWithReplyCount(keyword: String?, searchType: SearchType?, pageable: Pageable): PageDto {
        boardRepository.search(keyword, searchType, pageable)
        TODO("Not yet implemented")
    }


    fun getWithReplies(boardId: Long) {
        val board = boardRepository.findByIdOrNull(boardId) ?: throw EntityNotFoundException()
        val reply = replyRepository.findAllByBoard_BoardId(boardId)
    }

    @Transactional
    fun removeWithReplies(boardId: Long) {
        // cascade 옵션을 사용하지 않으므로 직접 삭제해야함
        // 1. 이미지 삭제, 댓글 삭제, 좋아요 삭제
        // 2. 게시글 삭제
    }

    @Transactional
    fun modify(board: Board) {
        // 1. 게시글 수정
        // 2. 이미지 수정
    }
}