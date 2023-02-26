package me.kzv.simpleboard.entity.user

import jakarta.persistence.DiscriminatorValue
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import me.kzv.simpleboard.entity.enums.SocialType

@Entity
@DiscriminatorValue("SOCIAL")
class SocialUser (

    /** 소셜 타입 */
    @Enumerated(EnumType.STRING)
    val socialType: SocialType,

    email: String,
    nickname: String

): User(email, nickname) {

}