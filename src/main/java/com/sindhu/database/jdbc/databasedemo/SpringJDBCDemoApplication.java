package com.sindhu.database.jdbc.databasedemo;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sindhu.database.jdbc.databasedemo.entity.Person;
import com.sindhu.database.jdbc.databasedemo.repos.PersonJdbcDao;

//@SpringBootApplication
public class SpringJDBCDemoApplication implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(SpringJDBCDemoApplication.class);
	@Autowired
	PersonJdbcDao dao;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringJDBCDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("All Users -> {}",dao.findAll());
		logger.info("User with Id: 10001 -> {}",dao.findById(10001));
		logger.info("Delete User with Id: 10002 -> {}",dao.deleteById(10002));
		logger.info("Insert User with Id: 10004 -> {}",dao.insert(new Person(10004, "Sam", "Hyderabad", new Date())));
		logger.info("Update User with Id: 10003 -> {}",dao.update(new Person(10003, "Lilly", "Charlotte", new Date())));

	}

}
