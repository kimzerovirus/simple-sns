package me.kzv.simpleboard.domain.reply

import me.kzv.simpleboard.domain.reply.entity.Reply
import org.springframework.data.jpa.repository.JpaRepository

interface ReplyRepository : JpaRepository<Reply, Long> {
    fun findAllByBoard_id(boardId: Long): List<Reply>
}