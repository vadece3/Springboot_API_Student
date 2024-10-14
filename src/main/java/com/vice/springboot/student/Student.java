package com.vice.springboot.student;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY
			)
	
	private Long id;
	private String name;
	private String email;
	private String dob;
	private String age;
	
	public Student() {
		
	}
	
	public Student(Long id,
					String name,
					String email,
					String dob,
					String age) {
		this.id=id;
		this.name=name;
		this.email=email;
		this.dob=dob;
		this.age=age;
	}
	
	public Student(String name,
			String email,
			String dob,
			String age) {
	this.name=name;
	this.email=email;
	this.dob=dob;
	this.age=age;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", email=" + email + ", dob=" + dob + ", age=" + age + "]";
	}
	

}
