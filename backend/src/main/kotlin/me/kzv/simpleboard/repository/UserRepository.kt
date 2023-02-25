package me.kzv.simpleboard.repository

import me.kzv.simpleboard.entity.user.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {
}