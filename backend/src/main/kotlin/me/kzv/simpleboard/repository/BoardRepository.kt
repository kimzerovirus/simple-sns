package me.kzv.simpleboard.repository

import me.kzv.simpleboard.entity.Board
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.jpa.repository.JpaRepository

interface BoardRepository : JpaRepository<Board, Long> {
    fun findByTitleContaining(title: String, pageable: Pageable): Page<Board>
    fun findByWriter_NicknameContaining(nickname: String, pageable: Pageable): Page<Board>
    fun findByContentContaining(content: String, pageable: Pageable): Page<Board>

    @EntityGraph(attributePaths = ["tags"])
    override fun findAll(): MutableList<Board>
}