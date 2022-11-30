package me.kzv.board.web.domain

import org.hibernate.annotations.GenericGenerator
import javax.persistence.*

@Entity
class Reply(
    @Id
    @GeneratedValue(generator = "sys-uuid")
    @GenericGenerator(name = "sys-uuid", strategy = "uuid")
    @Column(name = "reply_id")
    var id: String? = null,
    @Lob
    var text: String,
    var replyer: String,
    var replyType: Boolean, // false: 댓글 true: 대댓글
    var replyGroup: String? = null, // 대댓글일 경우 그룹 아이디가 있어야함

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    var post: Post,
) : BaseTimeEntity() {
}