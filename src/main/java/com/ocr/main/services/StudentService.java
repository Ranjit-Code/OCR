package com.ocr.main.services;

import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.ocr.main.entity.Student;
import com.ocr.main.repository.StudentRepository;

@Service
public class StudentService {

	private static final Logger log = LoggerFactory.getLogger(StudentService.class);

	private static String student_id = "772700";
	private static final String CVALUE = "c0";

	@Autowired
	StudentRepository studentRepository;

	public Iterable<Student> getStudents() {
		return studentRepository.findAll();
	}

	public Student create(Student student) throws Exception {
		try {
			student = generateStudentId(student);
			student = studentRepository.save(student);
		}catch(DataIntegrityViolationException ex) {
			throw new DataIntegrityViolationException(ex.getMessage());
		}catch(Exception ex) {
			throw new Exception("Something went wrong");
		}
		return student;
	}

	public Iterable<Student> edit(Iterable<Student> student) {
		return studentRepository.saveAll(student);
	}

	public Student partialEdit(Student student) {
		return studentRepository.save(student);
	}

	public void delete(int id) {
		studentRepository.deleteById(id);
	}

	public void findById(int id) {
		studentRepository.findById(id);
	}

	public Student generateStudentId(Student student) throws Exception {

		/*
		 * To Do Include the check if student id attribute sent in the API or NOT. If it
		 * is sent through API, should return error msg that student_id attribute should
		 * not be sent.
		 * 
		 */
		if (studentRepository.getMaxStudentId().isEmpty()) {
			student.setStudent_id(CVALUE.concat(student_id));
		} else {
			Student studentObj = studentRepository.getMaxStudentId().get(0);
			String tempStudentId = studentObj.getStudent_id();
			int studentId = Integer.valueOf(tempStudentId.substring(1));
			studentId = studentId + 1;
			student.setStudent_id(CVALUE.concat(String.valueOf(studentId)).toString());
		}
		return student;
	}
}
