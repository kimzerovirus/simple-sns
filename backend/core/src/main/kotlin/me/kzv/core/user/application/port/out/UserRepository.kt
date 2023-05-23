package me.kzv.core.user.application.port.out

import me.kzv.core.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long>
