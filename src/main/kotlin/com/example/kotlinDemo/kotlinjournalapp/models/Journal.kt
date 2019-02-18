package com.example.kotlinDemo.kotlinjournalapp.models

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.validation.constraints.NotBlank

@Entity
data class Journal(@Id @GeneratedValue(
	strategy = GenerationType.Identity) val id : Long = 0,
			@get: NotBlank val title : String = "",
			@get: NotBlank val content : String = ""){
}