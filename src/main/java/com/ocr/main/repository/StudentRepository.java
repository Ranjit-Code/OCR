package com.ocr.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ocr.main.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {
	
	@Query("FROM Student WHERE student_id=(SELECT max(student_id) FROM Student)")
	List<Student> getMaxStudentId();
}