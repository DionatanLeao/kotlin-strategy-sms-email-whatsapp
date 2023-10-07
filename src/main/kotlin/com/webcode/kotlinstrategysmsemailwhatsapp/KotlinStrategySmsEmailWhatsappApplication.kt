package com.webcode.kotlinstrategysmsemailwhatsapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@EnableFeignClients
@SpringBootApplication
class KotlinStrategySmsEmailWhatsappApplication

fun main(args: Array<String>) {
	runApplication<KotlinStrategySmsEmailWhatsappApplication>(*args)
}
