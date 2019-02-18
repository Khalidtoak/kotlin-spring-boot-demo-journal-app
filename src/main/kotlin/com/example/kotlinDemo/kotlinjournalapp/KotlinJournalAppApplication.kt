package com.example.kotlinDemo.kotlinjournalapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.SpringApplication

@SpringBootApplication
class KotlinJournalAppApplication

fun main(args: Array<String>) {
	SpringApplication.run(KotlinJournalAppApplication::class.java, *args)
}
