package me.kzv.simpleboard.service

import me.kzv.simpleboard.repository.BoardRepository
import me.kzv.simpleboard.entity.Board
import me.kzv.simpleboard.repository.UploadImgRepository
import me.kzv.simpleboard.repository.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional(readOnly = true)
@Service
class BoardService(
    private val boardRepository: BoardRepository,
    private val userRepository: UserRepository,
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