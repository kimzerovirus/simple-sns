package me.kzv.simpleboard.domain.img.entity

import jakarta.persistence.*
import me.kzv.simpleboard.domain.board.entity.Board

@DiscriminatorValue("BOARD")
class BoardImg(
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    val board: Board,
    imgNm: String,
    originImgNm: String,
    imgUrl: String,
) : UploadImg(imgNm = imgNm, originImgNm = originImgNm, imgUrl = imgUrl, imgType = ImgType.BOARD)
