package me.kzv.core.support.exception

class SimpleException(val error: SimpleError = SimpleError.UNKNOWN) : RuntimeException(error.messageKey)

enum class SimpleError(
    val messageKey: String
) {
    UNKNOWN("error.unknown"),
}