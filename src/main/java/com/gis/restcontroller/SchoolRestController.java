package com.gis.restcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gis.entity.SchoolEntity;
import com.gis.entity.StudentEntity;
import com.gis.repo.StudentRepo;

@RestController
public class SchoolRestController {

	    @Autowired
	    private StudentRepo schoolRepository;
	    
	   /* @PostMapping("/saveStudent")
	    public SchoolEntity createStudent(@RequestBody SchoolEntity student) {
	        return schoolRepository.saveAll(student);
	    }*/

	    @GetMapping("school/getAll")
	    public List<StudentEntity> getAllSchools() {
	        return  schoolRepository.findAll();
	    }



	    @GetMapping("school/{id}")
	    public ResponseEntity<SchoolEntity> getSchoolById(@PathVariable Integer id) {
	        Optional<StudentEntity> school = schoolRepository.findById(id);
	        if(school.isPresent()) {
	        	return new ResponseEntity<SchoolEntity>(HttpStatus.OK);
	        }
	        return new ResponseEntity<SchoolEntity>(HttpStatus.BAD_REQUEST);
	    }



	    @DeleteMapping("school/{id}")
	    public ResponseEntity<Void> deleteSchool(@PathVariable Integer id) {
	        if (!schoolRepository.existsById(id)) {
	            return ResponseEntity.notFound().build();
	        }
	        schoolRepository.deleteById(id);
	        return ResponseEntity.noContent().build();
	    }
	}



