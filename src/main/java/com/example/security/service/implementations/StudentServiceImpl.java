package com.example.security.service.implementations;

import com.example.security.DTO.CourseDto;
import com.example.security.DTO.StudentDto;
import com.example.security.repo.StudentRepo;
import com.example.security.service.interfaces.StudentService;
import com.example.security.utils.mapper.CourseMapper;
import com.example.security.utils.mapper.StudentMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepo studentRepo;
    private final StudentMapper studentMapper;
    private final CourseMapper courseMapper;

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

    @Override
    public List<CourseDto> getCoursesByStudentId(Long id) {
        log.info("Getting courses by user's id: {}", id);
        return studentRepo.findStudentCourses(id)
                .stream()
                .map(courseMapper::toDto)
                .toList();
    }
}
