package com.Student.demo.controller;

import com.Student.demo.dto.CourseDTO;
import com.Student.demo.model.Course;
import com.Student.demo.service.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
        return ResponseEntity.ok(courseService.getCourseById(id));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Course> createCourse(@RequestBody CourseDTO dto) {
        return ResponseEntity.ok(courseService.saveCourse(dto));
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Course> updateCourse(@PathVariable Long id, @RequestBody CourseDTO dto) {
        return ResponseEntity.ok(courseService.updateCourse(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Assign a Teacher to a Course")
    @PutMapping("/{courseId}/assign-teacher/{teacherId}")
    public ResponseEntity<Course> assignTeacherToCourse(@PathVariable Long courseId, @PathVariable Long teacherId) {
        return ResponseEntity.ok(courseService.assignTeacherToCourse(courseId, teacherId));
    }

    @Operation(summary = "Assign a Department to a Course")
    @PutMapping("/{courseId}/assign-department/{departmentId}")
    public ResponseEntity<Course> assignDepartmentToCourse(@PathVariable Long courseId, @PathVariable Long departmentId) {
        return ResponseEntity.ok(courseService.assignDepartmentToCourse(courseId, departmentId));
    }
}