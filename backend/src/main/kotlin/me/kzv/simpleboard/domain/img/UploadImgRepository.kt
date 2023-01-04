package me.kzv.simpleboard.domain.img

import me.kzv.simpleboard.domain.img.entity.UploadImg
import org.springframework.data.jpa.repository.JpaRepository

interface UploadImgRepository : JpaRepository<UploadImg, Long> {
}