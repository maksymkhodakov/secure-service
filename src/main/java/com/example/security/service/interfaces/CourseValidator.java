package com.example.security.service.interfaces;

import com.example.security.DTO.CourseDto;

public interface CourseValidator {
    boolean valid(CourseDto courseDto);
}
