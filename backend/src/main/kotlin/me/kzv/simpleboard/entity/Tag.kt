package me.kzv.simpleboard.entity

import jakarta.persistence.*

@Entity
@Table(
    uniqueConstraints = [
        UniqueConstraint(name = "uq_tag_name", columnNames = ["name"])
    ]
)
class Tag(

    /** 태그 이름 */
    @Column(unique = true)
    val name: String,

    /** 해당 게시글 */
    @OneToMany(mappedBy = "tag")
    val boards: MutableSet<BoardTag> = mutableSetOf()
): BaseEntity() {
//    init {
//        val regex = "[^ㄱ-ㅎ가-힣0-9a-zA-Z]".toRegex() // \uAC00-\uD7A3
//        this.name = name.replace(regex, "")
//    }

    override fun toString(): String {
        return "Tag(name='$name')"
    }
}