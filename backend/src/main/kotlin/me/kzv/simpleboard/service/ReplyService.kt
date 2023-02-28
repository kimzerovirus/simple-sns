package me.kzv.simpleboard.service

import me.kzv.simpleboard.repository.ReplyRepository
import org.springframework.stereotype.Service

@Service
class ReplyService(
    private val replyRepository: ReplyRepository,
) {

}