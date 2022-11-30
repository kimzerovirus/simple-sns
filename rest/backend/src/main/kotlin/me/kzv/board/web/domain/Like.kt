package me.kzv.board.web.domain

import me.kzv.board.web.domain.enums.LikeType
import javax.persistence.*

@Entity
@Table(name = "like_table")
class Like (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "like_id")
    var id: Long? = null,
    var likeType: LikeType,

    var userId: Long,

    var postId: Long,
) : BaseTimeEntity() {

    fun isLike(): Boolean = likeType.isLike()
}