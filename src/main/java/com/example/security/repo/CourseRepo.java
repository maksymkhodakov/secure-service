package com.example.security.repo;

import com.example.security.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepo extends JpaRepository<Course, Long> {
    Course findByCourseName(String courseName);
    List<Course> findByTeacherName(String teacherName);
}
