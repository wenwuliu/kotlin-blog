package com.web.kotlinspring

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication(scanBasePackages = ["com.web"])
class KotlinspringApplication

fun main(args: Array<String>) {
    runApplication<KotlinspringApplication>(*args)
}
