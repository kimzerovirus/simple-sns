package me.kzv.simpleboard.entity

import jakarta.persistence.*
import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.io.Serializable

// https://www.baeldung.com/jpa-entity-equality

@EntityListeners(AuditingEntityListener::class)
@MappedSuperclass
abstract class BaseEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var id: Long? = null,

    @CreatedBy
    @Column(updatable = false)
    open var createdBy: String? = null,

    @LastModifiedBy
    open var modifiedBy: String? = null
) : Serializable, BaseTimeEntity() {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is BaseEntity) return false

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id?.hashCode() ?: 0
    }
}

