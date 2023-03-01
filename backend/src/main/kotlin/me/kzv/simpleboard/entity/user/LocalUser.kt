package me.kzv.simpleboard.entity.user

import jakarta.persistence.Column
import jakarta.persistence.DiscriminatorValue
import jakarta.persistence.Entity

@Entity
@DiscriminatorValue("LOCAL")
class LocalUser (

    /** 비밀번호 */
    @Column(nullable = false)
    var password: String,

    email: String,

    nickname: String
): User(email, nickname) {
}