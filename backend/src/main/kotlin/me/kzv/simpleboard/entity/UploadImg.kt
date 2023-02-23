package me.kzv.simpleboard.entity

import jakarta.persistence.*
import me.kzv.simpleboard.entity.BaseEntity

@Entity
class UploadImg(
    val imgNm: String,
    val originImgNm: String,
    val imgUrl: String,
) : BaseEntity()

