package me.kzv.simpleboard.entity.user

import jakarta.persistence.*
import me.kzv.simpleboard.entity.BaseEntity
import me.kzv.simpleboard.entity.enums.Role
import me.kzv.simpleboard.entity.enums.SocialType

@Entity
@Table(
    name = "users",
    uniqueConstraints = [
        UniqueConstraint(name = "uq_user_email", columnNames = ["email"])
    ]
)
class User(
    @Column(nullable = false)
    val email: String,

    @Column(nullable = false)
    var nickname: String,

    var profileUrl: String? = null, // profile 이미지는 삭제 없이 덧씌워 버리면 될듯

    @Enumerated(EnumType.STRING)
    var role: Role = Role.USER,
) : BaseEntity() {

    fun update(nickname: String, profileUrl: String){
        this.nickname = nickname
        this.profileUrl = profileUrl
    }
}