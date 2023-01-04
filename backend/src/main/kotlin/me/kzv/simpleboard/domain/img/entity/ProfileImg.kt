package me.kzv.simpleboard.domain.img.entity

import jakarta.persistence.*
import me.kzv.simpleboard.domain.member.entity.Member

@DiscriminatorValue("Profile")
class ProfileImg(
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    val member: Member,
    imgNm: String,
    originImgNm: String,
    imgUrl: String,
) : UploadImg(imgNm = imgNm, originImgNm = originImgNm, imgUrl = imgUrl, imgType = ImgType.PROFILE)
