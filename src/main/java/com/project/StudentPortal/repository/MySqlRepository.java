package com.project.StudentPortal.repository;

import com.project.StudentPortal.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MySqlRepository extends JpaRepository<Student,Integer> {

}
