package me.kzv.core.support.exception

class SimpleException(error: SimpleError = SimpleError.UNKNOWN) : RuntimeException(error.messageKey)

enum class SimpleError(
    val messageKey: String? = null
) {
    UNKNOWN("error.unknown"),

    UNKNOWN_MODEL_TYPE("error.unknown.model.type"),

    EMAIL_AUTH_TIME_OUT("error.email.auth.time.out"),
}