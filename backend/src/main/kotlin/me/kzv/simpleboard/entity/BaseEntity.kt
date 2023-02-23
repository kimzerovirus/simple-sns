package me.kzv.simpleboard.entity

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.LastModifiedBy

@MappedSuperclass
abstract class BaseEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @CreatedBy
    @Column(updatable = false)
    private val createdBy: String? = null,

    @LastModifiedBy
    private val modifiedBy: String? = null
) : BaseTimeEntity()

