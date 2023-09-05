package com.gis.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Data
@Entity
public class TeacherEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer teacherId;

	private String teacherName;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "schoolid_fk")
    private SchoolEntity school;


	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name = "studentId_fk",referencedColumnName="teacherId")
	private List<StudentEntity> students;


}
