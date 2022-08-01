package com.example.security.repo;

import com.example.security.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CourseRepo extends JpaRepository<Course, Long> {
    Optional<Course> findByCourseName(String courseName);
    Optional<List<Course>> findByTeacherName(String teacherName);
}
