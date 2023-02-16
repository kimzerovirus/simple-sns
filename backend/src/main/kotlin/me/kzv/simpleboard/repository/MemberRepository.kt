package me.kzv.simpleboard.repository

import me.kzv.simpleboard.entity.Member
import org.springframework.data.jpa.repository.JpaRepository

interface MemberRepository : JpaRepository<Member, Long> {
}