package com.example.kotlinDemo.kotlinjournalapp

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class KotlinJournalAppApplication

fun main(args: Array<String>) {
	runApplication<KotlinJournalAppApplication>(*args)
}
