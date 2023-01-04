package me.kzv.simpleboard.domain.board.entity

import org.springframework.data.domain.Sort

enum class OrderType {
    ASC {
        override fun value() = Sort.by(Sort.Direction.ASC)
    },
    DESC {
        override fun value() = Sort.by(Sort.Direction.DESC)
    };

    abstract fun value(): Sort
}