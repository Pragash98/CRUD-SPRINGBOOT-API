package com.mpragash.spring.jpa.postgresql.service;


import com.mpragash.spring.jpa.postgresql.model.Student;
import com.mpragash.spring.jpa.postgresql.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;


	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Student getstudentById(Long id) {
		return studentRepository.findById(id).orElse(null);
	}

	@Override
	public Student createstudent(Student reqData) {
		return studentRepository.save(reqData);
	}
	
	@Override
	public Student updatestudent(Long id, Student reqData) {
		Student student = studentRepository.findById(id).orElse(null);
		if(student!=null){
			if(reqData.getName()!=null){
				student.setName(reqData.getName());
			}
			if(reqData.getDateofbirth()!=null){
				student.setDateofbirth(reqData.getDateofbirth());
			}
			if(reqData.getDateofjoining()!=null){
				student.setDateofjoining(reqData.getDateofjoining());
			}
			if(reqData.getclasses()!=null){
				student.setClasses(reqData.getclasses());
			}

			return  studentRepository.save(student);
		}

		return null;
	}

	@Override
	public boolean deletestudent(Long id) {
		Student student = studentRepository.findById(id).orElse(null);
		if(student!=null){
			studentRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public List<Student> searchstudent(String searchValue) {
		Long id = Long.MIN_VALUE;
		try{
			id = Long.parseLong(searchValue);
		}catch (Exception e){
			System.out.println("Filter Not a Long Value");
		}
		return studentRepository.findByNameContainingAndClassesContaining(searchValue,searchValue);
	}
}
