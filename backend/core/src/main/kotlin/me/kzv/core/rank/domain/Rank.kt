package me.kzv.core.rank.domain

import jakarta.persistence.*
import me.kzv.core.support.jpa.BaseAggregateRoot
import me.kzv.core.worldcup.domain.WorldCup

@Entity
@Table(
    name = "rank"
)
class Rank(

    @OneToOne
    val worldCup: WorldCup,

) : BaseAggregateRoot<Rank>()
