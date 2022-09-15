package com.project.StudentPortal.repositories;

import com.project.StudentPortal.models.Student;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {

}