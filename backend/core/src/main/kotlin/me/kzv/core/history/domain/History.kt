package me.kzv.core.history.domain

import jakarta.persistence.*
import me.kzv.core.support.jpa.BaseAggregateRoot
import me.kzv.core.worldcup.domain.WorldCup

/**
 * 로그인 후 게임을 한 유저는 결과를 히스토리에 저장하여
 * 추후에 게임 결과 리스트를 볼 수 있게 기록한다.
 * */
@Entity
@Table(
    name = "history"
)
class History(

    @OneToOne
    val worldCup: WorldCup,

) : BaseAggregateRoot<History>()
