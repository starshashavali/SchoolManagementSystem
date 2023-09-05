package com.gis.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gis.entity.StudentEntity;

public interface StudentRepo  extends JpaRepository<StudentEntity, Integer>{

}
