package me.kzv.simpleboard.entity

import jakarta.persistence.*
import me.kzv.simpleboard.entity.BaseEntity

@Entity
class UploadImg(

    /** 이미지 이름 */
    val imgNm: String,

    /** 이미지 이름 원본 */
    val originImgNm: String,

    /** 이미지 url주소 */
    val imgUrl: String,

) : BaseEntity()

