package me.kzv.simpleboard.entity.user

import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import me.kzv.simpleboard.entity.enums.SocialType

class SocialUser(

    @Enumerated(EnumType.STRING)
    val socialType: SocialType,
) {
}