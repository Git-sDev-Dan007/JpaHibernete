package com.LearnWithDan.SpringBoot.learn_jpa_._hibernate.jdbc;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CourseJPARepository {

	@PersistenceContext
	private EntityManager entityManager;
	public void insert(Course course) {
		entityManager.merge(course); //inserting a row 
	}
	public Course findByID(long id) {
		return entityManager.find(Course.class, id);
	}
	
	public void deleteByID(long id) {
		Course course = entityManager.find(Course.class, id);
	    entityManager.remove(course);
	}
	//Jpa maps the entity to the table ,thats it!
}
