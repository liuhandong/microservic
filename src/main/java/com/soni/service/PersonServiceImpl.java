package com.soni.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.soni.entity.Person;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PersonServiceImpl implements PersonService{
	
	private Map<Long, Person> personMap = new HashMap<>();
	
	@Override
    @Cacheable(value = "person", key = "'person'.concat(#id.toString())")
    public Person findPersonById(Long id) {
        log.info("findpersonById query from db, id: {}", id);
    	System.out.println("findpersonById query from db, id: {}======"+id);
        return personMap.get(id);
    }
	

    @Override
    @CachePut(value = "person", key = "'person'.concat(#person.id.toString())")
    public void update(Person person) {
        log.info("update db, person: {}", person.toString());
    	System.out.println("findpersonById query from db, id: {}======"+person.getId()+":"+person.getName());
    	personMap.put(person.getId(), person);
    }
 
    @Override
    @CacheEvict(value = "person", key = "'person'.concat(#id.toString())")
    public void remove(Long id) {
        log.info("remove from db, id: {}", id);
    	System.out.println("findpersonById query from db, id: {}======");
    	personMap.remove(id);
    }
 
	@Override
	@CacheEvict(value = "person", key = "'person'.concat(#id.toString())")
	public Person upPerson(Long id) {
		Person d= personMap.get(id);
		d.setName("000000000000000000000000000000000000000000000000");
		return d;
	}

}
