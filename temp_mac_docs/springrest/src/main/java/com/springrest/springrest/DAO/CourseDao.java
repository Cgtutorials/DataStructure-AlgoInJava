package com.springrest.springrest.DAO;

import com.springrest.springrest.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseDao extends JpaRepository<Course,Long> {

}
