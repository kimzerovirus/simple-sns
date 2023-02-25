package me.kzv.simpleboard.fixture

import me.kzv.simpleboard.entity.user.User
import me.kzv.simpleboard.entity.enums.Role
import me.kzv.simpleboard.entity.enums.SocialType

class UserFixture {
    companion object {
        fun get(email: String = "zerovirus96@gmail.com", nickname: String = "gosu", socialType: SocialType = SocialType.GOOGLE): User {
            return User(email = email, nickname = nickname, role = Role.USER)
        }
    }
}