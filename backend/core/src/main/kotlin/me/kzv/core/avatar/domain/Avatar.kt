package me.kzv.core.avatar.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table
import jakarta.persistence.UniqueConstraint
import me.kzv.core.support.jpa.BaseAggregateRoot

/**
 * 아바타
 */
@Entity
@Table(
    name = "avatar",
    uniqueConstraints = [
        UniqueConstraint(name = "uq_avatar_nickname", columnNames = ["nickname"])
    ]
)
class Avatar(

    /** 닉네임 */
    @Column(length = 50, nullable = false)
    var nickname: String,

    ) : BaseAggregateRoot<Avatar>() {

}