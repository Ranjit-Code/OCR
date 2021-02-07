package com.ocr.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ocr.main.entity.Student;
import com.ocr.main.services.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController extends AbstractRestHandler {
	
	@Autowired
	StudentService studentService;
	
	@GetMapping
	public Iterable<Student> getStudents() {
		return this.studentService.getStudents();
	}
	
	@PostMapping
	public Student create(@RequestBody Student student) throws Exception{
		return this.studentService.create(student);
	}
	
	@PutMapping
	public Iterable<Student> edit(@RequestBody Iterable<Student> student) {
		return this.studentService.edit(student);
	}	
	
	@PatchMapping
	public Student partialEdit(@RequestBody Student student) {
		return this.studentService.partialEdit(student);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") int id) {
		 this.studentService.delete(id);
	}
	
	@GetMapping("/{id}")
	public void findById(@PathVariable("id") int id) {
		 this.studentService.findById(id);
	}
}
