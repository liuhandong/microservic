package com.soni.service;

import com.soni.entity.Person;

public interface PersonService {

	Person findPersonById(Long id);

	Long update(Person person);

	void remove(Long id);

	Person upPerson(Long id);

}
