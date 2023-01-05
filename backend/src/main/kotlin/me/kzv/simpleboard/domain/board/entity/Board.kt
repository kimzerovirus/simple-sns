package me.kzv.simpleboard.domain.board.entity

import jakarta.persistence.*
import me.kzv.simpleboard.domain.BaseEntity
import me.kzv.simpleboard.domain.member.entity.Member
import me.kzv.simpleboard.domain.reply.entity.Reply

@Entity
class Board (
    title: String,
    content: String,
    writer: Member,
): BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id  : Long? = null

    @Column(nullable = false)
    var title: String = title
        private set

    @Column(nullable = false, columnDefinition = "TEXT")
    var content: String = content
        private set

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    val writer: Member = writer

    fun update(title: String, content: String) {
        this.title = title
        this.content = content
    }
}