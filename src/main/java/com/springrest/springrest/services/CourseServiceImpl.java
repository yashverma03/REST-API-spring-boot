package com.springrest.springrest.services;

// import java.util.ArrayList;
import java.util.List;
// import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entities.Course;

@Service
public class CourseServiceImpl implements CourseService {
  // List<Course> list;

  @Autowired
  private CourseDao courseDao;

  public CourseServiceImpl() {
    // list = new ArrayList<>();
    // list.add(new Course(145, "Java Core Course", "this course contains basics of
    // Java"));
    // list.add(new Course(4343, "Spring boot Course", "creating rest api using
    // spring boot"));
  }

  @Override
  public List<Course> getCourses() {
    // return list;

    return courseDao.findAll();
  }

  @Override
  public Course getCourse(long courseId) {
    // Course c = null;

    // for (Course course : list) {
    // if (course.getId() == courseId) {
    // c = course;
    // break;
    // }
    // }

    // return c;

    return courseDao.findById(courseId).orElse(null);
  }

  @Override
  public Course addCourse(Course course) {
    // list.add(course);
    courseDao.save(course);
    return course;
  }

  @Override
  public Course updateCourse(Course course) {
    // list.forEach(e -> {
    // if (e.getId() == course.getId()) {
    // e.setTitle(course.getTitle());
    // e.setDescription(course.getDescription());
    // }
    // });

    courseDao.save(course);
    return course;
  }

  @Override
  public void deleteCourse(long parseLong) {
    // list = this.list.stream().filter(e -> e.getId() !=
    // parseLong).collect(Collectors.toList());

    Course entity = courseDao.findById(parseLong).orElse(null);
    courseDao.delete(entity);
  }
}
