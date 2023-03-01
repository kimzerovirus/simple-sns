package me.kzv.simpleboard.entity.user

import jakarta.persistence.*
import me.kzv.simpleboard.entity.enums.SocialType

@Entity
@DiscriminatorValue("SOCIAL")
class SocialUser (

    /** 소셜 타입 */
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    val socialType: SocialType,

    email: String,

    nickname: String
): User(email, nickname) {

}