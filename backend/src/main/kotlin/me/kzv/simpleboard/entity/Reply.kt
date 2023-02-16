package me.kzv.simpleboard.entity

import jakarta.persistence.*

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

    @Column(nullable = true)
    val parentId: Long? = parenId

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    val board: Board = board

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    val replier: Member = replier
}