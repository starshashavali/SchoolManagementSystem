package com.gis.restcontroller;

import java.util.List;
import java.util.Optional;

import javax.persistence.GeneratedValue;

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
import com.gis.entity.TeacherEntity;
import com.gis.repo.TeacherRepo;

@RestController
public class TeacherRestController {
	@Autowired
	TeacherRepo teacherRepo;
	
	@PostMapping("/saveTeacher")
	public ResponseEntity<String> saveTeacher(@RequestBody TeacherEntity TeacherEntity){
		com.gis.entity.TeacherEntity save = teacherRepo.save(TeacherEntity);
		return new ResponseEntity<String>(HttpStatus.CREATED);
		
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateTeacher(@RequestBody TeacherEntity entity){
		
		if(entity!=null) {
			 teacherRepo.save(entity);
			return new ResponseEntity<String>("Data updated",HttpStatus.OK);
			
			
		}
		return new ResponseEntity<String>("Data not updated",HttpStatus.BAD_REQUEST);

		
		
	}
	
	@GetMapping("/getTeacher/{id}")
	public ResponseEntity<TeacherEntity > getTeacherById(@PathVariable Integer id){
		Optional<TeacherEntity> findById = teacherRepo.findById(id);
		if(findById.isPresent()) {
			TeacherEntity teacherEntity = findById.get();
			return new ResponseEntity<TeacherEntity>(teacherEntity,HttpStatus.OK);
		}
		return new ResponseEntity<TeacherEntity>(HttpStatus.BAD_REQUEST);
	}
	
	
	@GetMapping("/getAll")
	public List<TeacherEntity> getAllTeacher(){
		return teacherRepo.findAll();
	}
	@DeleteMapping("/deleteTeacher/{id}")
	public ResponseEntity<String> deleteByTeacher(@PathVariable Integer id){
		teacherRepo.deleteById(id);
		return new ResponseEntity<String>("Data deleted with Id:"+id,HttpStatus.OK);
		
	}
	

}
