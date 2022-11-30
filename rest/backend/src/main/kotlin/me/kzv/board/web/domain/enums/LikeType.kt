package me.kzv.board.web.domain.enums

// 기존에는 enum 을 문자열 값으로 저장하는 방식을 사용했지만
// 이번에는 Boolean 값을 이용하기 위해 추상 함수를 만들어 boolean 값을 반환하게 해줬다.
// https://kotlinlang.org/docs/enum-classes.html#working-with-enum-constants
enum class LikeType {
    LIKE {
        override fun isLike() = true
    },
    DISLIKE {
        override fun isLike() = false
    };

    abstract fun isLike(): Boolean
}