package me.kzv.simpleboard.entity

import jakarta.persistence.Column
import jakarta.persistence.MappedSuperclass
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import java.time.LocalDateTime

@MappedSuperclass
abstract class BaseTimeEntity (
    @CreatedDate
    @Column(updatable = false)
    private val createdAt: LocalDateTime? = null,

    @LastModifiedDate
    private val modifiedAt: LocalDateTime? = null
)