package com.example.db.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.db.model.Person;
import com.example.db.repository.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository personRepository;
	
	@Override
	public List<Person> getAllPeople() {
		List<Person> allPeople = personRepository.findAll();
		allPeople.sort((a, b) -> {
			if(a.getId() > b.getId()) {
				return 1;
			}
			return -1;
		});
		
		return allPeople;
	}
	
	@Override
	public Optional<Person> getPersonById(long id) {
		return personRepository.findById(id);
	}

	@Override
	public int updatePerson(Person update) {
		return getPersonById(update.getId()).map(person -> {
			personRepository.save(update);
			return 1;
		}).orElse(0);
	}

	@Override
	public int deletePerson(long id) {
		return getPersonById(id).map(person -> {
			personRepository.deleteById(id);
			return 1;
		}).orElse(0);
	}

	@Override
	public int addPerson(Person person) {
		personRepository.save(person);
		return 1;
	}

}
