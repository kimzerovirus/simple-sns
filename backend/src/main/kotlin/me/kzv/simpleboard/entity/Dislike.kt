package me.kzv.simpleboard.entity

import jakarta.persistence.*

@Entity
class Dislike(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = null,
    @ManyToOne @JoinColumn(name = "member_id") val member: Member,
    @ManyToOne @JoinColumn(name = "board_id") val board: Board,
) : BaseEntity()