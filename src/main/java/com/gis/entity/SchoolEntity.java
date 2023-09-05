package com.gis.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class SchoolEntity {
	@Id
	private Integer schoolId;
	
	private String schoolName;
	
	private String schoolLocation;
	

}
