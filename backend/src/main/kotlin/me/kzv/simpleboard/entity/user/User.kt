package me.kzv.simpleboard.entity.user

import jakarta.persistence.*
import me.kzv.simpleboard.entity.BaseEntity
import me.kzv.simpleboard.entity.enums.ActiveStatus
import me.kzv.simpleboard.entity.enums.Role
import me.kzv.simpleboard.entity.enums.SocialType

// https://www.baeldung.com/hibernate-inheritance
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "login_type")
@Entity
@Table(
    name = "users",
    uniqueConstraints = [
        UniqueConstraint(name = "uq_user_email", columnNames = ["email"])
    ]
)
abstract class User(

    /** 이메일 */
    @Column(length = 50, nullable = false)
    open var email: String,

    /** 닉네임 */
    @Column(length = 50, nullable = false)
    open var nickname: String,

    /** 프로필 이미지 url */
    open var profileUrl: String? = null, // profile 이미지는 삭제 없이 덧씌워 버리면 될듯

    /** 권한 */
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    open var role: Role = Role.USER,

    /** 상태 */
    @Column(nullable = false)
    open var status: ActiveStatus = ActiveStatus.ACTIVE,
    ) : BaseEntity() {
    fun update(nickname: String, profileUrl: String){
        this.nickname = nickname
        this.profileUrl = profileUrl
    }
}