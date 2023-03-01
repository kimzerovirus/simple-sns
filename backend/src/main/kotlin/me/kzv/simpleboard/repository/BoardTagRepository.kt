package me.kzv.simpleboard.repository

import me.kzv.simpleboard.entity.BoardTag
import org.springframework.data.jpa.repository.JpaRepository

interface BoardTagRepository : JpaRepository<BoardTag, Long>{
}