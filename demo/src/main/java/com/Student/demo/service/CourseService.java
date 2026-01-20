package com.Student.demo.service;

import com.Student.demo.dto.CourseDTO;
import com.Student.demo.model.Course;
import java.util.List;

public interface CourseService {
    List<Course> getAllCourses();
    Course saveCourse(CourseDTO dto);
    Course getCourseById(Long id);
    Course updateCourse(Long id, CourseDTO dto);
    void deleteCourse(Long id);
    Course assignTeacherToCourse(Long courseId, Long teacherId);
    Course assignDepartmentToCourse(Long courseId, Long departmentId);
}