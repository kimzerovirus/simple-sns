package me.kzv.simpleboard.entity

import jakarta.persistence.*
import me.kzv.simpleboard.entity.user.User

@Entity
@Table(name = "\"LIKE\"")
class Like(
    @ManyToOne @JoinColumn(name = "user_id") val user: User,
    @ManyToOne @JoinColumn(name = "board_id") val board: Board,
) : BaseEntity()