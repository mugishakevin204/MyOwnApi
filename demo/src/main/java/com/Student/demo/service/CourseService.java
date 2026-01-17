package com.Student.demo.service;

import com.Student.demo.model.Course;
import java.util.List;

public interface CourseService {
    List<Course> getAllCourses();
    Course saveCourse(Course course);

    Course getCourseById(Long id);
    void deleteCourse(Long id);
}