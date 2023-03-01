package me.kzv.simpleboard.entity

import jakarta.persistence.*

@Entity
class BoardTag(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @ManyToOne(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    val board: Board,

    @ManyToOne(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
    @JoinColumn(name = "tag_id")
    val tag: Tag,
)
