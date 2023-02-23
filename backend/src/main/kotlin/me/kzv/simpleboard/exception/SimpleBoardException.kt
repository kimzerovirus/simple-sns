package me.kzv.simpleboard.exception


class SimpleBoardException(val error: SimpleBoardError = SimpleBoardError.UNKNOWN) : RuntimeException(error.message)

enum class SimpleBoardError(
    val message: String? = null
) {
    UNKNOWN("알 수 없음"),

    USER_DUPLICATED_EMAIL("이미 가입된 이메일입니다."),

    EMAIL_AUTH_TIME_OUT("인증 제한시간을 초과하였습니다."),
}
