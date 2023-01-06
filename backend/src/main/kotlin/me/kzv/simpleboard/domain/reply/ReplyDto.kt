package me.kzv.simpleboard.domain.reply

import me.kzv.simpleboard.domain.img.ImgResponse

data class ReplyResponse (
    val id: Long,
    val parentId: Long?,
    val content: String,

    var imgs: List<ImgResponse>?,
)