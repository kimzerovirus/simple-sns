package me.kzv.simpleboard.domain.board

import me.kzv.simpleboard.domain.PageDto
import me.kzv.simpleboard.domain.board.entity.SearchType
import org.springframework.data.domain.Pageable

interface BoardCustomRepository {
    fun search(keyword: String?, searchType: SearchType?, pageable: Pageable): PageDto
}