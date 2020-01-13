package com.praxis.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.praxis.test.model.Professor;

@Repository
public interface ProfessorRepository extends JpaRepository <Professor, Long>{

}
