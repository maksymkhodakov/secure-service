package com.example.security.utils.mapper;

import com.example.security.DTO.StudentDto;
import com.example.security.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper extends AbstractMapper<Student, StudentDto> {
    @Autowired
    public StudentMapper() {
        super(Student.class, StudentDto.class);
    }
}
