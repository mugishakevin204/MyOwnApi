package com.Student.demo.service;

import com.Student.demo.model.Teacher;
import java.util.List;

public interface TeacherService {
    List<Teacher> getAllTeachers();
    Teacher saveTeacher(Teacher teacher);
    Teacher getTeacherById(Long id);
    Teacher updateTeacher(Long id, Teacher teacher);
    void deleteTeacher(Long id);
}