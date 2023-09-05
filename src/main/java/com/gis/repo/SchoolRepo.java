package com.gis.repo;

import org.springframework.data.repository.CrudRepository;

import com.gis.entity.SchoolEntity;

public interface SchoolRepo  extends CrudRepository<SchoolEntity, Integer>{

}
