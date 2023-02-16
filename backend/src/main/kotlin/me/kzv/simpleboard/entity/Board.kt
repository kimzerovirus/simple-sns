package me.kzv.simpleboard.entity

import jakarta.persistence.*

@Entity
class Board (
    title: String,
    content: String,
    writer: Member,
): BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    @Column(nullable = false)
    var title: String = title
        private set

    @Column(nullable = false, columnDefinition = "TEXT")
    var content: String = content
        private set

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    val writer: Member = writer

    @ManyToMany
    val tags: MutableSet<Tag> = mutableSetOf()

    fun update(title: String, content: String) {
        this.title = title
        this.content = content
    }

    fun addTag(tag: Tag){
        tags.add(tag)
    }

}