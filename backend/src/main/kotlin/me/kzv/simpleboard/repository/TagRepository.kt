package me.kzv.simpleboard.repository

import me.kzv.simpleboard.entity.Tag
import org.springframework.data.jpa.repository.JpaRepository

interface TagRepository : JpaRepository<Tag, Long> {
    fun findByNameIn(names: Set<String>): List<Tag>
}