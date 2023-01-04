package me.kzv.simpleboard.domain.reply.entity

import jakarta.persistence.*
import me.kzv.simpleboard.domain.BaseEntity
import me.kzv.simpleboard.domain.board.entity.Board
import me.kzv.simpleboard.domain.member.entity.Member

@Entity
class Reply(
    content: String,
    board: Board,
    replier: Member,
    parenId: Long?
) : BaseEntity() {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    @Column(nullable = false, columnDefinition = "TEXT")
    var content: String = content
        private set

    val parentId: Long? = parenId

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    val board: Board = board

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    val replier: Member = replier
}