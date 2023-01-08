package me.kzv.simpleboard.domain.like

import me.kzv.simpleboard.domain.like.entity.Like
import org.springframework.data.jpa.repository.JpaRepository

interface LikeRepository :JpaRepository<Like, Long> {
}