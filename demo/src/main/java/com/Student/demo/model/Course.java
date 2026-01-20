package com.Student.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Set;

@Entity
@Table(
        name = "courses",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "course_code")
        },
        indexes = {
                @Index(name = "idx_course_title", columnList = "title")
        }
)
@Data
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(example = "1", accessMode = Schema.AccessMode.READ_ONLY)
    private Long id;

    @Column(nullable = false)
    @Schema(example = "Introduction to Programming")
    private String title;

    @Column(name = "course_code", nullable = false)
    @Schema(example = "CS101")
    private String courseCode;

    // Many courses can belong to one teacher
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id", nullable = true)
    @JsonBackReference
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "department_id")
    @JsonBackReference
    private Department department;

    @ManyToMany(mappedBy = "enrolledCourses")
    @JsonBackReference
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Student> students;
}