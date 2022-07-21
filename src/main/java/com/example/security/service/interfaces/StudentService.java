package com.example.security.service.interfaces;

import com.example.security.DTO.CourseDto;
import com.example.security.DTO.StudentDto;

import java.util.List;

public interface StudentService {
    StudentDto save(StudentDto dto);
    StudentDto get(Long id);
    StudentDto getByNameAndSurname(String name, String surname);
    List<CourseDto> getCoursesByStudentId(Long id);
}
