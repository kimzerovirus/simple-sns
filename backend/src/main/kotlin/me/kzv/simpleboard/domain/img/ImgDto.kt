package me.kzv.simpleboard.domain.img

import me.kzv.simpleboard.domain.img.entity.ReplyImg

data class ImgResponse (
    val id: Long,
    val imgUrl: String,
)

fun ReplyImg.toImgResponse() = ImgResponse(id!!, imgUrl)

