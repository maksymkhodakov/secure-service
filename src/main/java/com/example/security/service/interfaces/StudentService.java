package com.example.security.service.interfaces;

import com.example.security.DTO.StudentDto;

public interface StudentService {
    StudentDto save(StudentDto dto);
    StudentDto get(Long id);
    StudentDto getByNameAndSurname(String name, String surname);
}
