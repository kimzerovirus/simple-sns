package me.kzv.simpleboard.domain.board

import me.kzv.simpleboard.domain.board.entity.Board
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface BoardRepository : JpaRepository<Board, Long>, BoardCustomRepository {
    fun findByTitleContaining(title: String, pageable: Pageable): Page<Board>
    fun findByWriter_NicknameContaining(nickname: String, pageable: Pageable): Page<Board>
    fun findByContentContaining(content: String, pageable: Pageable): Page<Board>
}