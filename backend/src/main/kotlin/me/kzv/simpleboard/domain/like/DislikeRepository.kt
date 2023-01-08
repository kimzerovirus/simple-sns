package me.kzv.simpleboard.domain.like

import me.kzv.simpleboard.domain.like.entity.Dislike
import me.kzv.simpleboard.domain.like.entity.Like
import org.springframework.data.jpa.repository.JpaRepository

interface DislikeRepository :JpaRepository<Dislike, Long> {
}