package fr.jetdev.jade

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class JadeApplication

fun main(args: Array<String>) {
    runApplication<JadeApplication>(*args)
}
