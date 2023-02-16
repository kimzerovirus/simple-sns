package me.kzv.simpleboard.service

import me.kzv.simpleboard.module.img.ImgResponse
import me.kzv.simpleboard.repository.UploadImgRepository
import me.kzv.simpleboard.module.img.entity.ReplyImg
import org.springframework.stereotype.Service

@Service
class UploadImgService(
    private val uploadImgRepository: UploadImgRepository,
    private val fileService: FileService,
){
    fun getBoardImgs(boardId: Long): List<ImgResponse> = uploadImgRepository.getBoardImgsByBoardId(boardId)
    fun getReplyImgs(boardId: Long): List<ReplyImg> = uploadImgRepository.getReplyImgsByBoardId(boardId)
}