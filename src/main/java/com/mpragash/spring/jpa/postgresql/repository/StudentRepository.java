package com.mpragash.spring.jpa.postgresql.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mpragash.spring.jpa.postgresql.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

	List<Student> findByNameContainingAndClassesContaining(String name, String classes);
}
