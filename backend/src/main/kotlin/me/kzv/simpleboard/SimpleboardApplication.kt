package me.kzv.simpleboard

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SimpleboardApplication

fun main(args: Array<String>) {
    runApplication<SimpleboardApplication>(*args)
}
