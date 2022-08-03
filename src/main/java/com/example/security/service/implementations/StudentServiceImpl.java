package com.example.security.service.implementations;

import com.example.security.DTO.StudentDto;
import com.example.security.domain.Student;
import com.example.security.exceptions.StudentSurnameNotFound;
import com.example.security.repo.StudentRepo;
import com.example.security.service.interfaces.StudentService;
import com.example.security.utils.mapper.StudentMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
@Transactional
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepo studentRepo;
    private final StudentMapper studentMapper;

    @Override
    public StudentDto save(StudentDto dto) {
        log.info("Saving student {} to db", dto.getStudentName());
        var student = studentMapper.toEntity(dto);
        studentRepo.save(student);
        return studentMapper.toDto(student);
    }

    @Override
    public StudentDto get(Long id) {
        var student = studentRepo.findById(id).orElseThrow();
        log.info("Getting student {} {} from db",
                student.getStudentName(), student.getStudentSurname());
        return studentMapper.toDto(student);
    }

    @Override
    public StudentDto getByNameAndSurname(String name, String surname) {
        var student = studentRepo.findStudentByStudentNameAndStudentSurname(name, surname);
        log.info("Getting student with name: {} {}", name, surname);
        return studentMapper.toDto(student);
    }

    @Override
    public List<StudentDto> getByStudentSurname(String surname) {
        var students = studentRepo.findByStudentSurname(surname)
                .orElseThrow(() -> new StudentSurnameNotFound("Students with surname " + surname +" not fount"));
        log.info("Getting student(s) with surname: {}", surname);
        return mapListOfEntitiesToListOfDto(students);
    }

    private List<StudentDto> mapListOfEntitiesToListOfDto(List<Student> students) {
        return students.stream()
                .map(studentMapper::toDto)
                .toList();
    }
}
