package me.kzv.simpleboard.domain.img.entity

import jakarta.persistence.*
import me.kzv.simpleboard.domain.board.entity.Board
import me.kzv.simpleboard.domain.reply.entity.Reply

@Entity
@DiscriminatorValue("REPLY")
class ReplyImg(
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    val board: Board,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reply_id")
    val reply: Reply,
    imgNm: String,
    originImgNm: String,
    imgUrl: String,
) : UploadImg(imgNm = imgNm, originImgNm = originImgNm, imgUrl = imgUrl)