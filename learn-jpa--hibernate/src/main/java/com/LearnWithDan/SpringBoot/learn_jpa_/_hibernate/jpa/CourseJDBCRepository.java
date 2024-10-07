package com.LearnWithDan.SpringBoot.learn_jpa_._hibernate.jpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.LearnWithDan.SpringBoot.learn_jpa_._hibernate.jdbc.Course;

@Repository //which talks to the database
public class CourseJDBCRepository {
   
	@Autowired //auto configured bean for jdbc temp => spring boot(starter type)
	private JdbcTemplate springJdbcTemplate;//this JdbcTemplate class gives us a lot of methods to implement sql queries

	private static String INSERT_QUERY=
			"""
			insert into course(id,name,author)
            values(?,?,?);
			""";
	private static String DELETE_QUERY=
			"""
			delete from course where id=?;
			""";
	private static String SELECT_QUERY=
			"""
			select * from course where id=?;
			""";
	
	public void insert(Course course) {
	//	springJdbcTemplate.update(INSERT_QUERY);//update:allows us to insert, update or delete statement
	
	springJdbcTemplate.update(INSERT_QUERY,course.getId(),course.getName(),course.getAuthor());
	
	}//now i want to execute this at the start of the application so i use (command line RUnner cls)
     
	public void deletebyID(long id) {
		springJdbcTemplate.update(DELETE_QUERY,id);
	}
	public Course findbyID(long id) {
		return springJdbcTemplate.queryForObject(SELECT_QUERY,new BeanPropertyRowMapper<>(Course.class),id);
	}
}
//so now we executed spring JDBC to execute sql queries and saw it in h2 database