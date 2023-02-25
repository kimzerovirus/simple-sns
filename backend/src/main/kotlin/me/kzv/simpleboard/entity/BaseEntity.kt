package me.kzv.simpleboard.entity

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.jpa.domain.support.AuditingEntityListener

@EntityListeners(AuditingEntityListener::class)
@MappedSuperclass
abstract class BaseEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @CreatedBy
    @Column(updatable = false)
    open var createdBy: String? = null,

    @LastModifiedBy
    open var modifiedBy: String? = null
) : BaseTimeEntity()

