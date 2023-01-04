package me.kzv.simpleboard.domain

import jakarta.persistence.Column
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime

abstract class BaseTimeEntity (
    @CreatedDate
    @Column(updatable = false)
    private val createdAt: LocalDateTime? = null,

    @LastModifiedDate
    private val modifiedAt: LocalDateTime? = null
)