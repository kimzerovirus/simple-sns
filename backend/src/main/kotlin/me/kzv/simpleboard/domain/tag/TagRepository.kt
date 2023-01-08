package me.kzv.simpleboard.domain.tag

import me.kzv.simpleboard.domain.tag.entity.Tag
import org.springframework.data.jpa.repository.JpaRepository

interface TagRepository : JpaRepository<Tag, Long> {
    fun findByNameIn(names: Set<String>): List<Tag>
}