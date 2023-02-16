package me.kzv.simpleboard.repository

import me.kzv.simpleboard.entity.Like
import org.springframework.data.jpa.repository.JpaRepository

interface LikeRepository :JpaRepository<Like, Long> {
}