package me.kzv.board.web.domain

import me.kzv.board.web.controller.dto.SignUpRequest
import me.kzv.board.web.domain.enums.AuthorityType
import me.kzv.board.web.domain.enums.VerifyType
import org.springframework.security.crypto.password.PasswordEncoder
import java.util.*
import javax.persistence.*

@Entity // Entity 의 기본 생성자는 public 또는 protected 여야함.
class Member private constructor(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    var id: Long? = null,
    @Column(unique = true)
    var email: String,
    var nickname: String,
    var password: String,

    @Enumerated(EnumType.STRING)
    var authorities: AuthorityType = AuthorityType.ROLE_VISITOR, // 이메일 인증을 안하면 VISITOR -> 인증 후 USER 계정으로 변경
//    @Enumerated(EnumType.STRING)
//    @ElementCollection(fetch = FetchType.LAZY) // default value = role_user
//    val authorities: MutableList<AuthorityType> = mutableListOf(AuthorityType.ROLE_USER),

    var emailVerified: VerifyType = VerifyType.UNVERIFIED,
    var emailVerifyToken: String? = null,
) : BaseTimeEntity() {

    companion object {
        fun createMember(dto: SignUpRequest, passwordEncoder: PasswordEncoder): Member = Member(
            email = dto.email,
            nickname = dto.nickname,
            password = passwordEncoder.encode(dto.password)
        )
    }

    fun completeEmailVerification() {
        emailVerified = VerifyType.VERIFIED
        authorities = AuthorityType.ROLE_USER
    }

    fun generateEmailVerifyToken() {
        emailVerifyToken = UUID.randomUUID().toString()
    }

    fun isValidToken(token: String): Boolean = emailVerifyToken.equals(token)
}

// companion object 는 companion 이라는 static 클래스를 통해 접근하는 것 같다. 따라서 그 안에 있는 변수나 메소드는 static 이 아니다.
// static method 를 만드는 방법
// https://blog.logrocket.com/create-static-methods-classes-kotlin/

// java 바이트 코드를 보니 MemberKt 라는 클래스를 만들고 그 안에 static 메소드로 createMember 가 생성되었다.
//fun createMember(dto: SignUpRequest, passwordEncoder: PasswordEncoder): Member = Member(
//    email = dto.email,
//    nickname = dto.nickname,
//    password = passwordEncoder.encode(dto.password),
//)
// <- 추) Kotlin in Action 4.4.2장을 보면 팩토리메소드는 companion object 안에 들어간다고 적혀있다.
// 또한 이렇게 사용할 경우 companion 즉, 동반자 이기 때문에 private 을 사용할 수 있으므로
// 생성자를 private 으로 만들어 서비스 로직에서 직접 생성자로 객체를 생성하지 않고 메소드만으로 생성하게 할 수 있다.
