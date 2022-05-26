package com.springrest.springrest.service;

import com.springrest.springrest.DAO.CourseDao;
import com.springrest.springrest.entities.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService{

    //public List<Course> courseList= new ArrayList<>();

    @Autowired
    private CourseDao courseDao;

    public CourseServiceImpl(List<Course> courseList) {
       /* this.courseList = courseList;
        courseList.add(new Course(1,"java","Java course"));
        courseList.add( new Course(2,"sql","sql course"));*/
    }

    @Override
    public List<Course> getCourses() {
      return courseDao.findAll();
    }

    @Override
    public Course getCoursebyId(long courseId) {
      /* Course c= null;
       for(Course course: courseList){
           if(course.getId()==courseId){
               c=course;
               break;
           }
       }*/
       return courseDao.getById(courseId);
    }

    @Override
    public Course addCourse(Course course) {

        courseDao.save(course);
        return course;
       /* courseList.add(course);
        return course;*/
    }

    @Override
    public Course updateCourse(Course course) {
       /*courseList.forEach(e->{
           if(e.getId()==course.getId()){
               e.setTitle(course.getTitle());
               e.setDescription(course.getDescription());
           }
       });*/

        courseDao.save(course);

       return course;
    }

    @Override
    public void deleteCourse(long courseId) {
        //courseList= this.courseList.stream().filter(e ->  e.getId()!=courseId).collect(Collectors.toList());
        courseDao.deleteById(courseId);
    }


}
