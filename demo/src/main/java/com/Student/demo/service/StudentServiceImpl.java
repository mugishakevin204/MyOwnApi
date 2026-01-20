package com.Student.demo.service;

import com.Student.demo.dto.StudentDTO;
import com.Student.demo.exception.ResourceNotFoundException;
import com.Student.demo.model.Course;
import com.Student.demo.model.Student;
import com.Student.demo.repository.CourseRepository;
import com.Student.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Page<Student> getAllStudents(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public Student saveStudent(StudentDTO dto) {
        Student student = new Student();
        student.setFirstName(dto.getFirstName());
        student.setLastName(dto.getLastName());
        student.setEmail(dto.getEmail());
        student.setEnrolledCourses(resolveCourses(dto.getCourseCodes()));
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));
    }

    @Override
    @Transactional
    public Student updateStudent(Long id, StudentDTO dto) {
        Student student = getStudentById(id);
        student.setFirstName(dto.getFirstName());
        student.setLastName(dto.getLastName());
        student.setEmail(dto.getEmail());
        student.setEnrolledCourses(resolveCourses(dto.getCourseCodes()));
        return studentRepository.save(student);
    }

    @Override
    @Transactional
    public void deleteStudent(Long id) {
        Student student = getStudentById(id);
        studentRepository.delete(student);
    }

    private Set<Course> resolveCourses(Set<String> courseCodes) {
        Set<Course> courses = new HashSet<>();
        if (courseCodes != null) {
            for (String code : courseCodes) {
                Course course = courseRepository.findByCourseCode(code)
                        .orElseThrow(() -> new ResourceNotFoundException("Course code not found: " + code));
                courses.add(course);
            }
        }
        return courses;
    }
}