package com.soni.entity;

import java.io.Serializable;

public class Person implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5207311106562881868L;
	/*
CREATE TABLE person(
id int PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(20),
age int,
nation VARCHAR(20),
address VARCHAR(20)
);



	 */
	Long id;
	String name;
	String age;
	String nation;
	String address;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Long getId() {
		return this.id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	

}
