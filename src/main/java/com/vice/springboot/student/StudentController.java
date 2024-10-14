package com.vice.springboot.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin

public class StudentController {
//	@GetMapping
//	public String hello() {
//		return "HELLO World";
//	}
//	
	private final StudentService studentService;
	
	@Autowired
	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}
	
	@RequestMapping(path = "api/v1/student1")
	@GetMapping
	public List<Student> getStudent1() {
		return studentService.getStudent1();
	}
	
	@RequestMapping(path = "api/v1/student2")
	@GetMapping
	public List<Student> getStudent2() {
		return studentService.getStudent2();
	}
	
	@RequestMapping(path = "api/v1/storeNewStudent")
	@PostMapping
	public String postStudent(@RequestBody Student student) {
		studentService.addNewStudent(student);
		return "New Student Added";
	}
	
	@RequestMapping(path = "api/v1/deleteStudent/{studentId}")
	@DeleteMapping
	public void deleteStudent(@PathVariable("studentId") Long studentId) {
		studentService.deleteStudent(studentId);
	}
	
	@RequestMapping(path = "api/v1/deleteStudent")
	@DeleteMapping
	public void deleteStudent1(@RequestBody Long studentId) {
		studentService.deleteStudent(studentId);
	}
	
	@RequestMapping(path = "api/v1/updateStudent/{studentId}")
	@PutMapping
	public void updateStudent1(
			@PathVariable("studentId") Long studentId,
			@RequestParam(required = false) String name,
			@RequestParam(required = false) String email) {
		studentService.updateStudent(studentId, name, email);
	}
	
	@RequestMapping(path = "api/v1/updateStudent")
	@PutMapping
	public void updateStudent2(
			@RequestBody Long studentId,
			@RequestParam(required = false) String name,
			@RequestParam(required = false) String email) {
		studentService.updateStudent(studentId, name, email);
	}

}
