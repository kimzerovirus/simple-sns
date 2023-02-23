package me.kzv.simpleboard.entity

import jakarta.persistence.*
import me.kzv.simpleboard.entity.enums.Role
import me.kzv.simpleboard.entity.enums.SocialType

@Entity
class Member(
    @Column(nullable = false)
    val email: String,

    @Column(nullable = false)
    var nickname: String,

    var profileUrl: String?, // profile 이미지는 삭제 없이 덧씌워 버리면 될듯

    @Enumerated(EnumType.STRING)
    var role: Role = Role.USER,

    @Enumerated(EnumType.STRING)
    val socialType: SocialType,
) : BaseEntity() {

    fun update(nickname: String, profileUrl: String){
        this.nickname = nickname
        this.profileUrl = profileUrl
    }
}