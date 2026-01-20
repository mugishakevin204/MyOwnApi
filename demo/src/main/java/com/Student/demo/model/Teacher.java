package com.Student.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList; // Added
import java.util.List;

@Entity
@Table(
        name = "teachers",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "email")
        },
        indexes = {
                @Index(name = "idx_teacher_lastname", columnList = "last_name")
        }
)
@Data
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    @Schema(example = "John")
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @Schema(example = "Doe")
    private String lastName;

    @Column(nullable = false)
    @Schema(example = "john.doe@example.com")
    private String email;

    // Modified: Added orphanRemoval and initialized the list to avoid NullPointerExceptions
    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<Course> courses = new ArrayList<>();

    // Helper method for the relationship
    public void addCourse(Course course) {
        courses.add(course);
        course.setTeacher(this);
    }
}