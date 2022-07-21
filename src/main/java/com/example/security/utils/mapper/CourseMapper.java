package com.example.security.utils.mapper;

import com.example.security.DTO.CourseDto;
import com.example.security.domain.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper extends AbstractMapper<Course, CourseDto> {
    @Autowired
    public CourseMapper() {
        super(Course.class, CourseDto.class);
    }
}
