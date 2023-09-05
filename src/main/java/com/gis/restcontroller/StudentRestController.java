package com.gis.restcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gis.entity.StudentEntity;
import com.gis.repo.StudentRepo;

@RestController
public class StudentRestController {

	    @Autowired
	    private StudentRepo studentRepository;

	    @GetMapping
	    public List<StudentEntity> getAllStudents() {
	        return studentRepository.findAll();
	    }

	    @PostMapping("/saveStudent")
	    public StudentEntity createStudent(@RequestBody StudentEntity student) {
	        return studentRepository.save(student);
	    }

	    @GetMapping("student/{id}")
	    public ResponseEntity<StudentEntity> getStudentById(@PathVariable Integer id) {
	        Optional<StudentEntity> student = studentRepository.findById(id);
	        return student.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	    }

	    @PutMapping("student/{id}")
	    public ResponseEntity<StudentEntity> updateStudent(@PathVariable Integer id, @RequestBody StudentEntity updatedStudent) {
	        if (!studentRepository.existsById(id)) {
	            return ResponseEntity.notFound().build();
	        }
	        
	        studentRepository.save(updatedStudent);
	        return ResponseEntity.ok(updatedStudent);
	    }

	    @DeleteMapping("student/{id}")
	    public ResponseEntity<Void> deleteStudent(@PathVariable Integer id) {
	        if (!studentRepository.existsById(id)) {
	            return ResponseEntity.notFound().build();
	        }
	        studentRepository.deleteById(id);
	        return ResponseEntity.noContent().build();
	    }
	}


