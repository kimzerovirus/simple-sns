package me.kzv.core.user.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table
import jakarta.persistence.UniqueConstraint
import me.kzv.core.support.jpa.BaseAggregateRoot

/**
 * 유저
 */
@Entity
@Table(
    name = "users",
    uniqueConstraints = [
        UniqueConstraint(name = "uq_user_email", columnNames = ["email"])
    ]
)
class User(

    /** 이메일 */
    @Column(length = 50, nullable = false)
    val email: String,

    /** 닉네임 */
    @Column(length = 50, nullable = false)
    var nickname: String,

) : BaseAggregateRoot<User>()
