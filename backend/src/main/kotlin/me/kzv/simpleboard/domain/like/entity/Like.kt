package me.kzv.simpleboard.domain.like.entity

import jakarta.persistence.*
import me.kzv.simpleboard.domain.BaseEntity
import me.kzv.simpleboard.domain.board.entity.Board
import me.kzv.simpleboard.domain.member.entity.Member

@Entity
@Table(name = "\"LIKE\"")
class Like(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long? = null,
    @ManyToOne @JoinColumn(name = "member_id") val member: Member,
    @ManyToOne @JoinColumn(name = "board_id") val board: Board,
) : BaseEntity()