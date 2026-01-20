package com.Student.demo.repository;

import com.Student.demo.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    // Allows looking up a course by "CS101" instead of ID
    Optional<Course> findByCourseCode(String courseCode);
}