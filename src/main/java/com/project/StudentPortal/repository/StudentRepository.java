package com.project.StudentPortal.repository;

import com.project.StudentPortal.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {

}
