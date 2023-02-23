package me.kzv.simpleboard.repository

import me.kzv.simpleboard.entity.UploadImg
import org.springframework.data.jpa.repository.JpaRepository

interface UploadImgRepository : JpaRepository<UploadImg, Long> {
}
