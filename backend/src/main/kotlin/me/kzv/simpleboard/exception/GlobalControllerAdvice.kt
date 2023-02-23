package me.kzv.simpleboard.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler

import org.springframework.web.bind.annotation.RestControllerAdvice


@RestControllerAdvice
class GlobalControllerAdvice {
    @ExceptionHandler(SimpleBoardException::class)
    fun customErrorHandler(e: SimpleBoardException): ResponseEntity<*> {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("bad_request")
    }

    @ExceptionHandler(IllegalArgumentException::class)
    fun defaultErrorHandler(e: IllegalArgumentException): ResponseEntity<*> {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("server_error")
    }
}