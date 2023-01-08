package me.kzv.simpleboard.domain.board

import me.kzv.simpleboard.domain.board.entity.Board
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.jpa.repository.JpaRepository

interface BoardRepository : JpaRepository<Board, Long>, BoardCustomRepository {
    fun findByTitleContaining(title: String, pageable: Pageable): Page<Board>
    fun findByWriter_NicknameContaining(nickname: String, pageable: Pageable): Page<Board>
    fun findByContentContaining(content: String, pageable: Pageable): Page<Board>

    @EntityGraph(attributePaths = ["tags"])
    override fun findAll(): MutableList<Board>
}