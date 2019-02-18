package com.example.kotlinDemo.kotlinjournalapp.controller

import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.beans.factory.annotation.Autowired
import com.example.kotlinDemo.kotlinjournalapp.repository.JournalRepository
import org.springframework.web.bind.annotation.GetMapping
import com.example.kotlinDemo.kotlinjournalapp.models.Journal
import org.springframework.web.bind.annotation.PostMapping
import javax.validation.Valid
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.http.HttpStatus

@RestController
@RequestMapping("/api")
class JournalController(@Autowired private val journalRepository : JournalRepository) {
	@GetMapping("/journals")
    fun getAllJournals() : List<Journal> = journalRepository.findAll()
	@PostMapping("/journals")
    fun createJournal(@Valid @RequestBody journal : Journal) : Journal = journalRepository.save(journal)
	@GetMapping("journals/{journalId}")
    fun getJournalById(@PathVariable journalId : Long) : ResponseEntity<Journal> =
		journalRepository.findById(journalId).map {
			ResponseEntity.ok(it)
		}.orElse(ResponseEntity.notFound().build())
	@PutMapping("/journals/{journalId}")
	fun updateJournal(@PathVariable journalId : Long,@Valid @RequestBody updatedJournal: Journal)
			 : ResponseEntity<Journal> =
		journalRepository.findById(journalId).map{
			val newJournal = it.copy(title = updatedJournal.title, content =  updatedJournal.content)
			ResponseEntity.ok().body(journalRepository.save(newJournal))
		}.orElse(ResponseEntity.notFound().build())
	@DeleteMapping("/journals/{journalId}")
    fun deleteJournal(@PathVariable journalId : Long) : ResponseEntity<Void> =
			journalRepository.findById(journalId).map{
				journalRepository.delete(it)
				ResponseEntity<Void>(HttpStatus.OK)
			}.orElse(ResponseEntity.notFound().build())
}