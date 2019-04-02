package com.sindhu.database.jdbc.databasedemo.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.sindhu.database.jdbc.databasedemo.entity.Person;

@Repository
@Transactional
public class PersonJpaRepository {
	//Connect to the database
	@PersistenceContext
	EntityManager entityManager;
	
	public List<Person> findAll() {
		// find_all_persons is a named query written in person class to retrieve all persons.
		TypedQuery<Person> namedQuery = entityManager.createNamedQuery("find_all_persons", Person.class);
		return namedQuery.getResultList(); //JPA
	}
	
	public Person findById(int id) {
		return entityManager.find(Person.class, id); //JPA
	}
	
	public Person update(Person person){
		return entityManager.merge(person);
	}
	
	public Person insert(Person person){
		return entityManager.merge(person);
	}
	
	public void deleteById(int id){
		Person person = findById(id);
		entityManager.remove(person);
	}
}
