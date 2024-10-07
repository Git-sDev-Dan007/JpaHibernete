package com.LearnWithDan.SpringBoot.learn_jpa_._hibernate.jdbc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner{

//	@Autowired
//	private CourseJDBCRepository repository;
	
	@Autowired
	public CourseSpringDataJpaRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		
    repository.save(new Course(1,"Learn JAVA now","Udemy")); 
	repository.save(new Course(2,"Learn SpringBoot Now","Udemy"));
	repository.save(new Course(3,"Learn JPA  Now","Coursera"));
	repository.deleteById(1l);
	System.out.println(repository.findById(2l));
	System.out.println(repository.findById(3l));
//	System.out.println(repository.findAll()); 
	System.out.println(repository.count());  
	System.out.println(repository.findByAuthor("Udemy"));
	}
}