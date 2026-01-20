package com.Student.demo.service;

import com.Student.demo.dto.CourseDTO;
import com.Student.demo.model.Course;
import com.Student.demo.model.Department;
import com.Student.demo.model.Teacher;
import com.Student.demo.repository.CourseRepository;
import com.Student.demo.repository.DepartmentRepository;
import com.Student.demo.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    @Transactional
    public Course saveCourse(CourseDTO dto) {
        Course course = new Course();
        course.setTitle(dto.getTitle());
        course.setCourseCode(dto.getCourseCode());
        course.setTeacher(resolveTeacher(dto.getTeacherId()));
        course.setDepartment(resolveDepartment(dto.getDepartmentId()));
        return courseRepository.save(course);
    }

    @Override
    public Course getCourseById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));
    }

    @Override
    @Transactional
    public Course updateCourse(Long id, CourseDTO dto) {
        Course course = getCourseById(id);
        course.setTitle(dto.getTitle());
        course.setCourseCode(dto.getCourseCode());
        course.setTeacher(resolveTeacher(dto.getTeacherId()));
        course.setDepartment(resolveDepartment(dto.getDepartmentId()));
        return courseRepository.save(course);
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Course assignTeacherToCourse(Long courseId, Long teacherId) {
        Course course = getCourseById(courseId);
        Teacher teacher = resolveTeacher(teacherId);
        course.setTeacher(teacher);
        return courseRepository.save(course);
    }

    @Override
    @Transactional
    public Course assignDepartmentToCourse(Long courseId, Long departmentId) {
        Course course = getCourseById(courseId);
        Department department = resolveDepartment(departmentId);
        course.setDepartment(department);
        return courseRepository.save(course);
    }

    private Teacher resolveTeacher(Long id) {
        if (id == null) return null;
        return teacherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Teacher not found"));
    }

    private Department resolveDepartment(Long id) {
        if (id == null) return null;
        return departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found"));
    }
}