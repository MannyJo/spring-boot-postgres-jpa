package com.example.db.service;

import java.util.List;
import java.util.Optional;

import com.example.db.model.Person;

public interface PersonService {

	public List<Person> getAllPeople();
	
	public Optional<Person> getPersonById(long id);
	
	public int updatePerson(Person person);
	
	public int deletePerson(long id);
	
	public int addPerson(Person person);

}
