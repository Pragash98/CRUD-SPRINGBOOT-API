package com.mpragash.spring.jpa.postgresql.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import com.mpragash.spring.jpa.postgresql.model.Student;
import com.mpragash.spring.jpa.postgresql.repository.StudentRepository;
import com.mpragash.spring.jpa.postgresql.service.StudentService;
//import com.mpragash.spring.jpa.postgresql.service.StudentServiceImpl;
import com.mpragash.spring.jpa.postgresql.bean.Response;


@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class StudentController {

	@Autowired
	StudentService studentService;
//	StudentRepository studentRepository;

	@GetMapping("/students")

	public ResponseEntity<?> getAllStudents() {
		        return new ResponseEntity<>(new Response<>(studentService.getAllStudents(),"students fetched",true), HttpStatus.OK);
		}


	@GetMapping("/students/{id}")
	public ResponseEntity<?> getstudentById(@PathVariable("id") long id) {
			Student student = studentService.getstudentById(id);
			return new ResponseEntity<>(new Response<>(student,(student!=null)? "Student fetched" : "Not found",true),(student!=null) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
		} 
	
	@PostMapping("/students")
	public ResponseEntity<?> createstudent(@RequestBody Student data) {
			return new ResponseEntity<>(new Response<>( studentService.createstudent(data),"Student Created",true), HttpStatus.CREATED);
		} 

	@PutMapping("/students/{id}")
	public ResponseEntity<?> updatestudent(@PathVariable("id") long id, @RequestBody Student data) {
			Student student = studentService.updatestudent(id, data);
			return new ResponseEntity<>(new Response<> (student,(student!=null) ? "Student updated":"Student not Found",true),(student!=null)? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/students/{id}")
	public ResponseEntity<?> deletestudent(@PathVariable("id") long id) {
			boolean deleteStudent = studentService.deletestudent(id);
			return new ResponseEntity<>(new Response<>(deleteStudent,(deleteStudent) ? "Student deleted":"Student not found",true),(deleteStudent) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("search/{id}")
	public ResponseEntity<?> searchstudent(@PathVariable("id") String searchValue) {
	List<Student> student = studentService.searchstudent(searchValue);
	return new ResponseEntity<>(new Response<>(student,
	(student!=null)? "Students fetched successfully !" : "Student Not Found!", true),(student!=null) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}

}
