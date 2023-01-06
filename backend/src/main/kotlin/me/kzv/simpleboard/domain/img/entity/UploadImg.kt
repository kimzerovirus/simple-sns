package me.kzv.simpleboard.domain.img.entity

import jakarta.persistence.*
import me.kzv.simpleboard.domain.BaseEntity

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING, name = "img_type")
abstract class UploadImg(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open val id  : Long? = null,
    open val imgNm: String,
    open val originImgNm: String,
    open val imgUrl: String,
) : BaseEntity()

