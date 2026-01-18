package com.Student.demo.service;

import com.Student.demo.model.Course;
import java.util.List;

public interface CourseService {

    List<Course> getAllCourses();

    Course saveCourse(Course course);

    Course getCourseById(Long id);

    Course updateCourse(Long id, Course courseDetails);

    void deleteCourse(Long id);
}
