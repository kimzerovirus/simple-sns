package me.kzv.simpleboard.entity

import jakarta.persistence.*
import me.kzv.simpleboard.entity.BaseEntity

@Entity
class UploadImg(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id  : Long? = null,
    val imgNm: String,
    val originImgNm: String,
    val imgUrl: String,
) : BaseEntity()

