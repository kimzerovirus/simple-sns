package me.kzv.simpleboard.entity

import jakarta.persistence.*
import me.kzv.simpleboard.entity.enums.ActiveStatus
import me.kzv.simpleboard.entity.user.User

@Entity
class Board(

    /** 제목 */
    @Column(nullable = false)
    var title: String,

    /** 글 내용 */
    @Column(nullable = false, columnDefinition = "TEXT")
    var content: String,

    /** 상태 */
    @Column(length = 20, nullable = false)
    var status: ActiveStatus = ActiveStatus.ACTIVE,

    /** 이미지 */
    @ElementCollection
    @CollectionTable(name = "board_img", joinColumns = [JoinColumn(name = "post_id")])
    @Column(name = "upload_img")
    val imgs: MutableList<BoardImg> = mutableListOf(),

    /** 글 작성자 */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    val user: User,

    @OneToMany(mappedBy = "board")
    val tags: MutableSet<BoardTag> = mutableSetOf(),
) : BaseEntity() {
    fun update(title: String, content: String) {
        this.title = title
        this.content = content
    }

    override fun toString(): String {
        return "Board(title='$title', content='$content', status=$status)"
    }
}