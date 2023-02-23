package me.kzv.simpleboard.entity

import jakarta.persistence.*

@Entity
class Dislike(
    @ManyToOne @JoinColumn(name = "member_id") val member: Member,
    @ManyToOne @JoinColumn(name = "board_id") val board: Board,
) : BaseEntity()