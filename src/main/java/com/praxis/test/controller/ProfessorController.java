package com.praxis.test.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.praxis.test.model.Professor;
import com.praxis.test.repository.ProfessorRepository;
@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/api/v1")
public class ProfessorController implements CommonDAO<Professor>{

    @Autowired
    private ProfessorRepository professorRepository;

    @GetMapping("/professors")
    @Override
    public List<Professor> getAll() {
        return professorRepository.findAll();
    }

    @GetMapping("/professors/{id}")
    @Override
    public ResponseEntity<Professor> getById(@PathVariable(value = "id") Long professorId)
            throws Exception {
        Professor professor = professorRepository.findById(professorId).orElseThrow(() -> new Exception("Error on professor: " + professorId));
        return ResponseEntity.ok().body(professor);
    }

    @DeleteMapping("/professors/{id}")
    @Override
    public Map<String, Boolean> delete(@PathVariable(value = "id") Long professorId)
            throws Exception {
        Professor professor = professorRepository.findById(professorId).orElseThrow(() -> new Exception("Error on professor: " + professorId));
        professorRepository.delete(professor);
        Map <String, Boolean> response = new HashMap< >();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @PostMapping("/professors")
    public Professor createProfessor(@Valid @RequestBody Professor professor) {
        return professorRepository.save(professor);
    }

    @PutMapping("/professors/{id}")
    public ResponseEntity<Professor> updateProfessor(@PathVariable(value = "id") Long professorId,
                                                 @Valid @RequestBody Professor professorDetails) throws Exception {
        Professor professor = professorRepository.findById(professorId).orElseThrow(() -> new Exception("Error on professor: " + professorId));

        professor.setName(professorDetails.getName());
        professor.setPhoneNumber(professorDetails.getPhoneNumber());
        professor.setEmailAddress(professorDetails.getEmailAddress());
        professor.setAddress(professorDetails.getAddress());
        professor.setSalary(professorDetails.getSalary());
        final Professor updatedProfessor = professorRepository.save(professor);
        return ResponseEntity.ok(updatedProfessor);
    }

}
