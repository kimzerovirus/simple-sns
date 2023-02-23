package me.kzv.simpleboard.entity

import jakarta.persistence.*

@Entity
class Tag(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @Column(unique = true)
    val name: String,
) {
//    init {
//        val regex = "[^ㄱ-ㅎ가-힣0-9a-zA-Z]".toRegex() // \uAC00-\uD7A3
//        this.name = name.replace(regex, "")
//    }
}