package me.kzv.simpleboard.domain.img

import me.kzv.simpleboard.domain.board.entity.Board
import me.kzv.simpleboard.domain.img.entity.ReplyImg
import me.kzv.simpleboard.domain.reply.entity.Reply
import org.springframework.stereotype.Service

@Service
class UploadImgService(
    private val uploadImgRepository: UploadImgRepository,
    private val fileService: FileService,
){
    fun getBoardImgs(boardId: Long): List<ImgResponse> = uploadImgRepository.getBoardImgsByBoardId(boardId)
    fun getReplyImgs(boardId: Long): List<ReplyImg> = uploadImgRepository.getReplyImgsByBoardId(boardId)
}