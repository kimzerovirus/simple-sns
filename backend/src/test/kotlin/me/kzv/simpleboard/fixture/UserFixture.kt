package me.kzv.simpleboard.fixture

import me.kzv.simpleboard.entity.user.User
import me.kzv.simpleboard.entity.enums.Role
import me.kzv.simpleboard.entity.enums.SocialType
import me.kzv.simpleboard.entity.user.LocalUser
import me.kzv.simpleboard.entity.user.SocialUser

class UserFixture {
    companion object {
        fun createLocalUser(email: String = "zerovirus96@gmail.com", nickname: String = "gosu", password: String = "1234"): User {
            return LocalUser(email = email, nickname = nickname, password = password)
        }

        fun createSocialUser(email: String = "zerovirus96@gmail.com", nickname: String = "gosu", socialType: SocialType = SocialType.GOOGLE): User {
            return SocialUser(email = email, nickname = nickname, socialType = socialType)
        }
    }
}