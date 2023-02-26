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

    /** 게시글 등록 */
    @Transactional
    fun register(board: Board): Board {
       return boardRepository.save(board)
    }

    /** 게시글 조회 - 단건 조회*/
    @Transactional(readOnly = true)
    fun getOne(){

    }

    /** 게시글 조회 - 페이징 리스트 */
    @Transactional(readOnly = true)
    fun getListByPaging(){

    }

    /** 게시글 수정 */
    @Transactional
    fun modify(board: Board) {
        // 1. 게시글 수정
        // 2. 이미지 수정
    }

    /** 게시글 삭제 */
    @Transactional
    fun remove(boardId: Long) {
        // 1. 이미지 삭제, 댓글 삭제, 좋아요 삭제
        // 2. 게시글 삭제
    }

}