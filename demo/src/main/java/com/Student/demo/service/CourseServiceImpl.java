package com.Student.demo.service;

import com.Student.demo.model.Course;
import com.Student.demo.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course saveCourse(Course course) {
        return courseRepository.save(course);
    }

    // ADD THESE TWO METHODS:
    @Override
    public Course getCourseById(Long id) {
        return courseRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Course not found for id: " + id));
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}