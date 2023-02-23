package me.kzv.simpleboard.entity

import jakarta.persistence.*

@Entity
class Board (
    @Column(nullable = false)
    var title: String,

    @Column(nullable = false, columnDefinition = "TEXT")
    var content: String ,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    val writer: Member,

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