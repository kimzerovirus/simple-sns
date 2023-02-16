package me.kzv.simpleboard.entity

import jakarta.persistence.*
import me.kzv.simpleboard.entity.enums.Role
import me.kzv.simpleboard.entity.enums.SocialType

@Entity
class Member(
    email: String,
    nickname: String,
    socialType: SocialType,
) : BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    @Column(nullable = false)
    val email: String = email

    @Column(nullable = false)
    var nickname: String = nickname
        private set

    var profileUrl: String? = null
        private set

    @Enumerated(EnumType.STRING)
    var role: Role = Role.USER
        private set

    @Enumerated(EnumType.STRING)
    val socialType: SocialType = socialType

    fun updateNickname(nickname: String){
        this.nickname = nickname
    }

    fun updateProfileUrl(profileUrl: String){
        this.profileUrl = profileUrl
    }
}