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

import com.praxis.test.model.Student;
import com.praxis.test.repository.StudentRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class StudentController implements CommonDAO<Student> {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/students")
    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @GetMapping("/students/{id}")
    @Override
    public ResponseEntity<Student> getById(@PathVariable(value = "id") Long studentId)
            throws Exception {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new Exception("Error on student: " + studentId));
        return ResponseEntity.ok().body(student);
    }

    @DeleteMapping("/students/{id}")
    @Override
    public Map<String, Boolean> delete(@PathVariable(value = "id") Long studentId)
            throws Exception {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new Exception("Error on student: " + studentId));
        studentRepository.delete(student);
        Map <String, Boolean> response = new HashMap < > ();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @PostMapping("/students")
    public Student createStudent(@Valid @RequestBody Student student) {
        return studentRepository.save(student);
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable(value = "id") Long studentId,
                                                 @Valid @RequestBody Student studentDetails) throws Exception {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new Exception("Error on student: " + studentId));

        student.setName(studentDetails.getName());
        student.setPhoneNumber(studentDetails.getPhoneNumber());
        student.setEmailAddress(studentDetails.getEmailAddress());
        student.setAddress(studentDetails.getAddress());
        student.setStudentNumber( studentDetails.getStudentNumber());
        student.setAverageMark(studentDetails.getAverageMark());
        final Student updatedStudent = studentRepository.save(student);
        return ResponseEntity.ok(updatedStudent);
    }

}
