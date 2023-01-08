package me.kzv.simpleboard.domain.tag.entity

import jakarta.persistence.*

@Entity
class Tag (name: String){
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    @Column(unique = true)
    var name: String
        private set

    init {
        val regex = "[^ㄱ-ㅎ가-힣0-9a-zA-Z]".toRegex() // \uAC00-\uD7A3
        this.name = name.replace(regex,"")
    }
}