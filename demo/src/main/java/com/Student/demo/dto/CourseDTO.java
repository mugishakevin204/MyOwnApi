package com.Student.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CourseDTO {
    private String title;
    private String courseCode;
    private Long teacherId;
    private Long departmentId;

}