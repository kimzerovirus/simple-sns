package me.kzv.simpleboard.repository

import me.kzv.simpleboard.entity.Reply
import org.springframework.data.jpa.repository.JpaRepository

interface ReplyRepository : JpaRepository<Reply, Long> {
    fun findAllByBoard_id(boardId: Long): List<Reply>
}