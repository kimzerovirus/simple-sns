package me.kzv.board.web.domain

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.LocalDateTime
import javax.persistence.EntityListeners
import javax.persistence.MappedSuperclass

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class) // Auditing 기능 포함
abstract class BaseTimeEntity(

    @CreatedDate
    var createdAt: LocalDateTime? = null,

    @LastModifiedDate
    var updateAt: LocalDateTime? = null
)