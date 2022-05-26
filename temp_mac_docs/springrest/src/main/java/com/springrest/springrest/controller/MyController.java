package com.springrest.springrest.controller;

import com.springrest.springrest.entities.Course;
import com.springrest.springrest.service.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@RestController
public class MyController {



    @Autowired
    private CourseServiceImpl courseService;

    @GetMapping("/home")
    public String home(){
        return "This is the home Page";
    }

    // get the coursers
    @GetMapping("/courses")
    public List<Course> getCourses(){
        return this.courseService.getCourses();

}

    // get the coursers with ID
    @GetMapping("/courses/{courseId}")
    public Course getCourses(@PathVariable String courseId){
        return this.courseService.getCoursebyId(Long.parseLong(courseId));


    }

    @PostMapping("/courses")
    public Course addCourse(@RequestBody Course course){
        return this.courseService.addCourse(course);
    }

    @PutMapping("/Courses")
    public Course updateCourse(@RequestBody Course course){
        return this.courseService.updateCourse(course);
    }

    @DeleteMapping("/courses/{courseId}")
    public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId){
        try{
            this.courseService.deleteCourse(Long.parseLong(courseId));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


}
