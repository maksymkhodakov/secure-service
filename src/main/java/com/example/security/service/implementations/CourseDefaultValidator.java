package com.example.security.service.implementations;

import com.example.security.DTO.CourseDto;
import org.springframework.stereotype.Component;

@Component("defaultCourseValidator")
public class CourseDefaultValidator implements com.example.security.service.interfaces.CourseValidator {
    @Override
    public boolean valid(CourseDto courseDto) {
        return courseDto.getCourseName().endsWith("course") &&
                courseDto.getCourseName().length() > 5 &&
                courseDto.getCourseName().length() < 20 &&
                courseDto.getTeacherName().length() > 0 &&
                courseDto.getTeacherName().length() < 100 &&
                !courseDto.getStudents().isEmpty();
    }
}
