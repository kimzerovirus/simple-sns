package me.kzv.simpleboard.entity

import jakarta.persistence.Embeddable
import jakarta.persistence.Embedded

@Embeddable
class BoardImg (

    /** 업로드 이미지 이름 */
    var imgName: String,

    /** 업로드 이미지 url 위치 */
    var imgUrl: String,
)
