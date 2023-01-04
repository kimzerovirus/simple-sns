package me.kzv.simpleboard.domain.img.entity

import jakarta.persistence.DiscriminatorValue
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import me.kzv.simpleboard.domain.reply.entity.Reply

@DiscriminatorValue("REPLY")
class ReplyImg(
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reply_id")
    val reply: Reply,
    imgNm: String,
    originImgNm: String,
    imgUrl: String,
) : UploadImg(imgNm = imgNm, originImgNm = originImgNm, imgUrl = imgUrl, imgType = ImgType.REPLY)