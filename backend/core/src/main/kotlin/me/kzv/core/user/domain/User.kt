package me.kzv.core.user.domain

import jakarta.persistence.*
import jakarta.persistence.EnumType
import me.kzv.core.support.jpa.BaseAggregateRoot
import org.springframework.security.crypto.password.PasswordEncoder
import java.time.LocalDateTime

/**
 * 유저
 */
@Entity
@Table(
    name = "users",
    uniqueConstraints = [
        UniqueConstraint(name = "uq_user_email", columnNames = ["email"])
    ]
)
class User(

    /** 이메일 */
    @Column(length = 50, nullable = false)
    val email: String,

    /** 비밀번호 */
    @Column(length = 20, nullable = false)
    var password: String,

    /** 마지막 비밀번호 설정일 */
    var lastPasswordModifiedDate: LocalDateTime = LocalDateTime.now(),

    /** 만료 상태 (휴면 여부) */
    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    var expireStatus: UserExpire = UserExpire.UNEXPIRED,

    /** 생성 IP 주소 */
    var createIp: String,

    /** 업데이트 IP 주소 */
    var lastModifiedIp: String,

    /** 잠금 상태 */
    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    var lockStatus: UserLock,

    /** 잠금 사유 */
    var lockedReason: String? = null,

    /** 잠금 날짜 */
    var lockedDate: LocalDateTime? = null,

    /** 회원가입 타입 */
    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    var joinType: JoinType

    ) : BaseAggregateRoot<User>() {

    companion object {

        /** 비밀번호 유효 기간 3개월 */
        private const val PASSWORD_EXPIRATION_MONTH = 3L

        /** 이메일 미인증 */
        private const val EMAIL_AUTH_NOT_YET = "이메일 미인증 유저"

        /**
         * 플랫폼 유저 생성
         */
        fun create(email: String, password: String, ip: String, passwordEncoder: PasswordEncoder): User {
            return User(
                email = email, password = passwordEncoder.encode(password), createIp = ip,
                lastModifiedIp = ip, lockStatus = UserLock.LOCKED, lockedReason = EMAIL_AUTH_NOT_YET,
                lockedDate = LocalDateTime.now(), joinType = JoinType.PLATFORM
            )
        }

        /**
         * oauth 유저 생성
         */
        fun createByOauth(email: String, ip: String): User {
            return User(
                email = email, password = "oauth user", createIp = ip,
                lastModifiedIp = ip, lockStatus = UserLock.UNLOCKED, joinType = JoinType.OAUTH
            )
        }

    }

    /**
     *  이메일 미인증 유저인지 확인
     * */
    fun isEmailAuthNotYet(): Boolean{
        check(this.lockStatus == UserLock.LOCKED)

        return this.lockedReason == EMAIL_AUTH_NOT_YET
    }

    /**
     * 현재 날짜가 비밀번호 만료 날짜 보다 이전인가?
     */
    fun isExpiredPassword(): Boolean {
        val now = LocalDateTime.now()
        val expiryDate = this.lastPasswordModifiedDate.plusMonths(PASSWORD_EXPIRATION_MONTH)

        return now.isBefore(expiryDate)
    }

    /**
     * 휴면 유저로 전환
     */
    fun expire() {
        this.expireStatus = UserExpire.EXPIRED
    }

}
