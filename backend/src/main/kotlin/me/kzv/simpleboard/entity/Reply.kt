package me.kzv.simpleboard.entity

import jakarta.persistence.*
import me.kzv.simpleboard.entity.user.User

@Entity
class Reply(
    @Column(nullable = false, columnDefinition = "TEXT")
    var content: String,

    @Column(nullable = true)
    val parentId: Long?,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    val board: Board,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    val replier: User,
) : BaseEntity() {

}