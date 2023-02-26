package me.kzv.simpleboard.entity

import jakarta.persistence.*
import me.kzv.simpleboard.entity.enums.ActiveStatus
import me.kzv.simpleboard.entity.user.User

@Entity
class Board (

    /** 제목 */
    @Column(nullable = false)
    var title: String,

    /** 글 내용 */
    @Column(nullable = false, columnDefinition = "TEXT")
    var content: String,

    /** 상태 */
    @Column(nullable = false)
    var status: ActiveStatus = ActiveStatus.ACTIVE,

    /** 글 작성자 */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    val writer: User,

//    @ManyToMany
//    val tags: MutableSet<Tag> = mutableSetOf(),

): BaseEntity() {
    fun update(title: String, content: String) {
        this.title = title
        this.content = content
    }

//    fun addTag(tag: Tag){
//        tags.add(tag)
//    }

}