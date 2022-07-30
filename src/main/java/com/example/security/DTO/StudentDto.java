package com.example.security.DTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Collection;

@Data
@EqualsAndHashCode(callSuper = true)
public class StudentDto extends AbstractDto {
    private String studentName;
    private String studentSurname;
    private Collection<CourseDto> courses;
}
