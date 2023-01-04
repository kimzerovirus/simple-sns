package me.kzv.simpleboard.domain.img.entity

import jakarta.persistence.*
import me.kzv.simpleboard.domain.BaseEntity

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn
abstract class UploadImg(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id  : Long? = null,
    val imgNm: String,
    val originImgNm: String,
    val imgUrl: String,
    @Enumerated(EnumType.STRING)
    val imgType: ImgType,
) : BaseEntity()
