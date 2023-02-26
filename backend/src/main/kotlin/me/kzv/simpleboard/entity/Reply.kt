package me.kzv.simpleboard.entity

import jakarta.persistence.*
import me.kzv.simpleboard.entity.enums.ActiveStatus
import me.kzv.simpleboard.entity.user.User

@Entity
class Reply(

    /** 댓글 내용 */
    @Column(nullable = false, columnDefinition = "TEXT")
    var content: String,

    /** 계층형 댓글 - 부모 댓글 아이디 */
    @Column(nullable = true)
    val parentId: Long?,

    /** 상태 */
    @Column(nullable = false)
    var status: ActiveStatus = ActiveStatus.ACTIVE,

    /** 본문 게시글 인덱스 */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    val board: Board,

    /** 댓글 작성자 인덱스 */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    val replier: User,

    ) : BaseEntity() {

}