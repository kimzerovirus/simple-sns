package me.kzv.simpleboard.domain.img

import me.kzv.simpleboard.domain.board.entity.Board
import me.kzv.simpleboard.domain.reply.entity.Reply
import org.springframework.stereotype.Service

@Service
class UploadImgService(
    private val uploadImgRepository: UploadImgRepository,
    private val fileService: FileService,
){
    fun getBoardImgs(board: Board): List<ImgResponse> = uploadImgRepository.getImgsByBoard(board)
    fun getReplyImgs(reply: Reply): List<ImgResponse> = uploadImgRepository.getImgsByReply(reply)
}