package me.kzv.simpleboard.service

import me.kzv.simpleboard.module.img.entity.ReplyImg
import me.kzv.simpleboard.module.img.toImgResponse
import me.kzv.simpleboard.module.reply.ReplyResponse
import me.kzv.simpleboard.module.reply.toReplyResponse
import me.kzv.simpleboard.repository.ReplyRepository
import org.springframework.stereotype.Service

@Service
class ReplyService(
    private val replyRepository: ReplyRepository,
    private val imgService: UploadImgService,
) {
    fun getRepliesWithImgs(boardId: Long): List<ReplyResponse> {
        val replyResponseList = mutableListOf<ReplyResponse>()

        val replyList = replyRepository.findAllByBoard_id(boardId)
        val replyImgList = imgService.getReplyImgs(boardId) as MutableList<ReplyImg>
        for (reply in replyList) {
            val replyResponse = reply.toReplyResponse()
            for (replyImg in replyImgList) {
                if (reply == replyImg.reply) replyResponse.imgs.add(replyImg.toImgResponse())
            }
            replyResponseList.add(replyResponse)
        }

        return replyResponseList
    }
}