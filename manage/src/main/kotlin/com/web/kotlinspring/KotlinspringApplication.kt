package com.web.kotlinspring

import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@MapperScan(basePackages = ["com.web.common.dao"])
@SpringBootApplication(scanBasePackages = ["com.web"])
class KotlinspringApplication

fun main(args: Array<String>) {
    runApplication<KotlinspringApplication>(*args)
}
