package io.pivotal.shinyay.controller

import io.pivotal.shinyay.entity.Person
import io.pivotal.shinyay.repository.PersonRepository
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/persons")
class PersonController(val repository: PersonRepository) {

    @GetMapping
    fun findAll() = repository.findAll()

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Int) = repository.findById(id)

    @PostMapping
    fun add(@RequestBody person: Person) = repository.save(person)

    @PutMapping
    fun update(@RequestBody person: Person) = repository.update(person)

    @DeleteMapping("/{id}")
    fun remove(@PathVariable id: Int) = repository.removeById(id)
}