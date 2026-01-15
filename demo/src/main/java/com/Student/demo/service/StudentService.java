package com.Student.demo.service;

import com.Student.demo.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudentService {
    // This keeps your pagination working
    Page<Student> getAllStudents(Pageable pageable);

    Student saveStudent(Student student);
    Student getStudentById(Long id);
    void deleteStudent(Long id);

    // NEW: The method for the PUT request
    Student updateStudent(Long id, Student student);
}