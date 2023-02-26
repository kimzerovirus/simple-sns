package me.kzv.simpleboard.entity

import jakarta.persistence.*

@Entity
class Tag(

    @Column(unique = true)
    val name: String,

): BaseEntity() {
//    init {
//        val regex = "[^ㄱ-ㅎ가-힣0-9a-zA-Z]".toRegex() // \uAC00-\uD7A3
//        this.name = name.replace(regex, "")
//    }
}