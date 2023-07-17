package me.kzv.core.worldcup.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import me.kzv.core.support.jpa.BaseAggregateRoot
import me.kzv.core.user.domain.User

/**
 * 월드컵
 *
 * 썸네일은 각 플랫폼에서 제공하는 이미지로 하면 될듯
 * https://stackoverflow.com/questions/39830844/how-get-the-thumbnail-from-youtube
 */
@Entity
@Table(
    name = "worldcup"
)
class WorldCup(

    /** 제목 */
    @Column(length = 50, nullable = false)
    var title: String,

    /** 설명 */
    @Column(nullable = false)
    var description: String,

    /** 썸네일1 */
    @Column(nullable = false)
    val thumbnail1: String,

    /** 썸네일2 */
    @Column(nullable = false)
    val thumbnail2: String,

    @ManyToOne
    val user: User,

) : BaseAggregateRoot<WorldCup>()
