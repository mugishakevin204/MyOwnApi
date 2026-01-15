package com.Student.demo.service;

import com.Student.demo.model.Department;
import java.util.List;

public interface DepartmentService {
    List<Department> getAllDepartments();
    Department saveDepartment(Department department);
    Department updateDepartment(Long id, Department department);
    void deleteDepartment(Long id);
}