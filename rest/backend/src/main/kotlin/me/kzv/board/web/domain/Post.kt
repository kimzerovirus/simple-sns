package me.kzv.board.web.domain

import javax.persistence.*

@Entity
class Post(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var title: String,
    @Lob
    var content: String,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    var member: Member,
    var isVisible: Boolean = true, // 관리자만 감추기 기능 추가
    // 이미지
) : BaseTimeEntity() {
    var likeCnt = 0
    var disLikeCnt = 0

    fun increaseLikeCnt() {
        likeCnt++
    }

    fun decreaseLikeCnt() {
        likeCnt--
    }

    fun increaseDisLikeCnt() {
        disLikeCnt++
    }

    fun decreaseDisLikeCnt() {
        disLikeCnt--
    }
}