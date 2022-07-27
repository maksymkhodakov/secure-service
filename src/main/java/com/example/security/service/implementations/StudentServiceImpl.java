package com.example.security.service.implementations;

import com.example.security.DTO.StudentDto;
import com.example.security.repo.StudentRepo;
import com.example.security.service.interfaces.StudentService;
import com.example.security.utils.mapper.StudentMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

@Slf4j
@Service
@Transactional
public class StudentServiceImpl implements StudentService {
    private final StudentRepo studentRepo;
    private final StudentMapper studentMapper;

    public StudentServiceImpl(StudentRepo studentRepo,
                              StudentMapper studentMapper) {
        this.studentRepo = studentRepo;
        this.studentMapper = studentMapper;
    }

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
        log.info("Getting student with name: {} {}", student.getStudentName(), student.getStudentSurname());
        return studentMapper.toDto(student);
    }
}
