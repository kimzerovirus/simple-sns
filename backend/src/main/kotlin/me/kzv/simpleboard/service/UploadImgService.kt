package me.kzv.simpleboard.service

import me.kzv.simpleboard.repository.UploadImgRepository
import org.springframework.stereotype.Service

@Service
class UploadImgService(
    private val uploadImgRepository: UploadImgRepository,
    private val fileService: FileService,
){

}