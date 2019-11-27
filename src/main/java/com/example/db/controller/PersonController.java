package com.example.db.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.db.model.Person;
import com.example.db.service.PersonServiceImpl;

@RequestMapping("api/person")
@RestController
public class PersonController {

	@Autowired
	private PersonServiceImpl personService;
	
	@GetMapping("all")
	public List<Person> getAllPeople() {
		return personService.getAllPeople();
	}
	
	@GetMapping("{id}")
	public Person getPersonById(@PathVariable long id) {
		return personService.getPersonById(id).orElse(null);
	}
	
	@PostMapping("add")
	public void addPerson(@RequestBody Person person) {
		personService.addPerson(person);
	}
	
	@PutMapping("update")
	public void updatePerson(@RequestBody Person person) {
		personService.updatePerson(person);
	}
	
	@DeleteMapping("delete/{id}")
	public void deletePerson(@PathVariable("id") long id) {
		personService.deletePerson(id);
	}

}
