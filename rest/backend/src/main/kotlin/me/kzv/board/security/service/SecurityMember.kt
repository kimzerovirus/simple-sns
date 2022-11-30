package me.kzv.board.security.service

import me.kzv.board.web.domain.Member
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.User

/** UserDetails 를 상속받은 시큐리티 멤버 객체 */
class SecurityMember(
    member: Member,
    authorities: Collection<GrantedAuthority>,
) : User(member.email, member.password, authorities) { // UserDetails 를 implements 해도 되지만 필요한 부분만 구현하기 위해 User 객체를 상속하여 수정한다.

    private val member: Member = member

    fun getMemberInfo(): Member = member

    override fun isEnabled(): Boolean {
        // active 유저인지 검증
        return true
    }
}