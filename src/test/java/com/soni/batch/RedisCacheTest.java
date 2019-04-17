package com.soni.batch;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.soni.batch.apprun.Application;
import com.soni.entity.Person;
import com.soni.service.PersonService;


@RunWith(SpringRunner.class)
@SpringBootTest(classes=Application.class)
public class RedisCacheTest {
	@Autowired
	PersonService personService;
	
	//@Test
	public void findPersonById() {
		Long id=10L;
		personService.findPersonById(id);
	}
	
	@Test
	public void update() {
		Person person = new Person();
		Long id = 38L;
		person.setId(id);
		person.setName("test08");
		person.setAddress("dalian");
		person.setAge("25");
		person.setNation("CHINA");
		personService.update(person);
		System.out.println("-----first------------");
		System.out.println( personService.findPersonById(id).getName());
		System.out.println("-----second------------");
		System.out.println( personService.findPersonById(id).getName());
	}
	

}
