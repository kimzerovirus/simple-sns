package me.kzv.simpleboard.entity

import jakarta.persistence.Column
import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.LastModifiedBy

abstract class BaseEntity(
    @CreatedBy
    @Column(updatable = false)
    private val createdBy: String? = null,

    @LastModifiedBy
    private val modifiedBy: String? = null
) : BaseTimeEntity()

