package com.praxis.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.praxis.test.model.Student;

@Repository
public interface StudentRepository extends JpaRepository <Student, Long>{

}