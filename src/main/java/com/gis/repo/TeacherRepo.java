package com.gis.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gis.entity.TeacherEntity;

public interface TeacherRepo extends JpaRepository<TeacherEntity, Integer> {

}
