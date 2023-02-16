package me.kzv.simpleboard.repository

import me.kzv.simpleboard.entity.Dislike
import org.springframework.data.jpa.repository.JpaRepository

interface DislikeRepository :JpaRepository<Dislike, Long> {
}