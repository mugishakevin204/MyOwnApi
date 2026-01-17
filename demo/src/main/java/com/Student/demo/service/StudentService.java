package com.Student.demo.service;

import com.Student.demo.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudentService {
    Page<Student> getAllStudents(Pageable pageable);

    Student saveStudent(Student student);
    Student getStudentById(Long id);
    void deleteStudent(Long id);

    Student updateStudent(Long id, Student student);
}