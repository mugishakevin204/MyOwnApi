package com.Student.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
public class StudentDTO {
    private String firstName;
    private String lastName;
    private String email;
    private Set<String> courseCodes;

}