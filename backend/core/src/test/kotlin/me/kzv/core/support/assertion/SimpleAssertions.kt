package me.kzv.core.support.assertion

import me.kzv.core.support.exception.SimpleError
import me.kzv.core.support.exception.SimpleException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows

fun assertSimpleExceptionThrows(error: SimpleError, executable: () -> Unit) {
    val simpleException = assertThrows<SimpleException>(executable)

    assertThat(simpleException.error).isEqualTo(error)
}