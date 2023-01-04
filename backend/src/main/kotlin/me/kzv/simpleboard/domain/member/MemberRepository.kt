package me.kzv.simpleboard.domain.member

import me.kzv.simpleboard.domain.member.entity.Member
import org.springframework.data.jpa.repository.JpaRepository

interface MemberRepository : JpaRepository<Member, Long> {
}