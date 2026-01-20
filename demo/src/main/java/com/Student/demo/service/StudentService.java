package com.Student.demo.service;

import com.Student.demo.dto.StudentDTO;
import com.Student.demo.model.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudentService {
    Page<Student> getAllStudents(Pageable pageable);
    Student saveStudent(StudentDTO dto);
    Student getStudentById(Long id);
    void deleteStudent(Long id);
    Student updateStudent(Long id, StudentDTO dto);
}