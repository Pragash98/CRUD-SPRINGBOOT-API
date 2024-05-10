 package com.mpragash.spring.jpa.postgresql.service;
 
 import com.mpragash.spring.jpa.postgresql.model.Student;
 
 import java.util.List;
 
 public interface StudentService {
	 public List<Student> getAllStudents();
	 public Student getstudentById(Long id);
	 public List<Student> searchstudent(String searchValue); 
	 public Student createstudent(Student data);
	 public Student updatestudent(Long id,Student Data);
	 public boolean deletestudent(Long id);
 }