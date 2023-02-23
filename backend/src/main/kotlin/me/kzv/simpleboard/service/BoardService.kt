package me.kzv.simpleboard.service

import jakarta.persistence.EntityNotFoundException
import me.kzv.simpleboard.controller.dtos.PageResponseDto
import me.kzv.simpleboard.repository.BoardRepository
import me.kzv.simpleboard.entity.Board
import me.kzv.simpleboard.entity.enums.SearchType
import me.kzv.simpleboard.repository.UploadImgRepository
import me.kzv.simpleboard.repository.MemberRepository
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional(readOnly = true)
@Service
class BoardService(
    private val boardRepository: BoardRepository,
    private val memberRepository: MemberRepository,
    private val imgRepository: UploadImgRepository,
    private val replyService: ReplyService,
) {

    @Transactional
    fun remove(boardId: Long) {
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