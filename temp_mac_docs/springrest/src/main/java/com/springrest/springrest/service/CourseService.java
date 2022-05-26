package com.springrest.springrest.service;

import com.springrest.springrest.entities.Course;

import java.util.List;

public interface CourseService {

    public List<Course> getCourses();

    public Course getCoursebyId(long courseId);
    public Course addCourse(Course course);
    public Course updateCourse(Course course);
    public void deleteCourse(long courseId);


}
