package me.kzv.simpleboard.domain.reply

import me.kzv.simpleboard.domain.img.ImgResponse
import me.kzv.simpleboard.domain.reply.entity.Reply

data class ReplyResponse (
    val id: Long,
    val parentId: Long?,
    val content: String,

    var imgs: MutableList<ImgResponse> = mutableListOf(),
)

fun Reply.toReplyResponse() = ReplyResponse(id!!, parentId, content)