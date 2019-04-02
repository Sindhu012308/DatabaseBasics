package com.sindhu.database.jdbc.databasedemo.repos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.sindhu.database.jdbc.databasedemo.entity.Person;

@Repository
public class PersonJdbcDao {
	 
	// Use JdbcTemplate to create the database connection in Spring
	@Autowired
	JdbcTemplate jdbcTemplate;

	//we created inner class because this class can be used only in PersonJdbcDao class only and
	//Instead of using BeanPropertyRowMapper we can create our own row mapper to match the result to the person data.
	
	class PersonRowMapper implements RowMapper<Person>{

		@Override
		public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
			Person person = new Person();
			person.setId(rs.getInt("id"));
			person.setName(rs.getString("name"));
			person.setLocation(rs.getString("location"));
			person.setBirthDate(rs.getTimestamp("birth_date"));
			return person;
			
		}
		
	}
	
	//select * from Person
	public List<Person> findAll(){
		return jdbcTemplate.query("select * from person", 
				new PersonRowMapper());
		/* return jdbcTemplate.query("select * from person", 
				new BeanPropertyRowMapper<Person>(Person.class)); */
	}
	
	public Person findById(int id){
		return jdbcTemplate.queryForObject("select * from person where id=?", new Object[] {id},
				new PersonRowMapper());
		
		/* return jdbcTemplate.queryForObject("select * from person where id=?", new Object[] {id},
				new BeanPropertyRowMapper<Person>(Person.class)); */
	}
	
	public int deleteById(int id){
		return jdbcTemplate.update("delete from person where id=?", new Object[] {id});
	}
	
	public int insert(Person person){
		return jdbcTemplate.update("\n" + 
				"insert into person(id, name, location,birth_date) values(?,?,?,?)",
				new Object[] {person.getId(),person.getName(), person.getLocation(), new Timestamp(person.getBirthDate().getTime())});
	}
	
	public int update(Person person){
		return jdbcTemplate.update("\n" + 
				"update person "
				+ " set name = ? , location = ? , birth_date = ?"
				+ "where id = ?",
				new Object[] {person.getName(), person.getLocation(), new Timestamp(person.getBirthDate().getTime()),person.getId()});
	}
}

