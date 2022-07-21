package com.example.security.DTO;

import com.example.security.domain.Course;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Collection;

@Data
@EqualsAndHashCode(callSuper = true)
public class StudentDto extends AbstractDto {
    private String studentName;
    private String studentSurname;
    private Collection<Course> courses;
}
