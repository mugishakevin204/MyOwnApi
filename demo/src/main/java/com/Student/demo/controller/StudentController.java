package com.Student.demo.controller;

import com.Student.demo.dto.StudentDTO;
import com.Student.demo.model.Student;
import com.Student.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public ResponseEntity<Page<Student>> getAllStudents(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(studentService.getAllStudents(PageRequest.of(page, size)));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> createStudent(@RequestBody StudentDTO dto) {
        Student savedStudent = studentService.saveStudent(dto);
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Student> updateStudent(
            @PathVariable Long id,
            @RequestBody StudentDTO dto) {
        return ResponseEntity.ok(studentService.updateStudent(id, dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{studentId}/assign-department/{departmentId}")
    public ResponseEntity<Student> assignDepartmentToStudent(
            @PathVariable Long studentId,
            @PathVariable Long departmentId) {
        return ResponseEntity.ok(studentService.assignDepartmentToStudent(studentId, departmentId));
    }
}