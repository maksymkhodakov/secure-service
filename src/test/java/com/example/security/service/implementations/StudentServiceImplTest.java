package com.example.security.service.implementations;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.security.DTO.StudentDto;
import com.example.security.domain.Student;
import com.example.security.exceptions.StudentSurnameNotFound;
import com.example.security.repo.StudentRepo;
import com.example.security.utils.mapper.StudentMapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {StudentServiceImpl.class})
@ExtendWith(SpringExtension.class)
class StudentServiceImplTest {
    @MockBean
    private StudentMapper studentMapper;

    @MockBean
    private StudentRepo studentRepo;

    @Autowired
    private StudentServiceImpl studentServiceImpl;

    /**
     * Method under test: {@link StudentServiceImpl#save(StudentDto)}
     */
    @Test
    void testSave() {
        Student student = new Student();
        student.setCourses(new ArrayList<>());
        student.setCreated(LocalDateTime.of(1, 1, 1, 1, 1));
        student.setId(123L);
        student.setStudentName("Student Name");
        student.setStudentSurname("Doe");
        student.setUpdated(LocalDateTime.of(1, 1, 1, 1, 1));
        when(studentRepo.save((Student) any())).thenReturn(student);

        StudentDto studentDto = new StudentDto();
        studentDto.setCourses(new ArrayList<>());
        studentDto.setCreated(LocalDateTime.of(1, 1, 1, 1, 1));
        studentDto.setId(123L);
        studentDto.setStudentName("Student Name");
        studentDto.setStudentSurname("Doe");
        studentDto.setUpdated(LocalDateTime.of(1, 1, 1, 1, 1));

        Student student1 = new Student();
        student1.setCourses(new ArrayList<>());
        student1.setCreated(LocalDateTime.of(1, 1, 1, 1, 1));
        student1.setId(123L);
        student1.setStudentName("Student Name");
        student1.setStudentSurname("Doe");
        student1.setUpdated(LocalDateTime.of(1, 1, 1, 1, 1));
        when(studentMapper.toDto((Student) any())).thenReturn(studentDto);
        when(studentMapper.toEntity((StudentDto) any())).thenReturn(student1);

        StudentDto studentDto1 = new StudentDto();
        studentDto1.setCourses(new ArrayList<>());
        studentDto1.setCreated(LocalDateTime.of(1, 1, 1, 1, 1));
        studentDto1.setId(123L);
        studentDto1.setStudentName("Student Name");
        studentDto1.setStudentSurname("Doe");
        studentDto1.setUpdated(LocalDateTime.of(1, 1, 1, 1, 1));
        assertSame(studentDto, studentServiceImpl.save(studentDto1));
        verify(studentRepo).save((Student) any());
        verify(studentMapper).toDto((Student) any());
        verify(studentMapper).toEntity((StudentDto) any());
    }

    /**
     * Method under test: {@link StudentServiceImpl#save(StudentDto)}
     */
    @Test
    void testSave2() {
        Student student = new Student();
        student.setCourses(new ArrayList<>());
        student.setCreated(LocalDateTime.of(1, 1, 1, 1, 1));
        student.setId(123L);
        student.setStudentName("Student Name");
        student.setStudentSurname("Doe");
        student.setUpdated(LocalDateTime.of(1, 1, 1, 1, 1));
        when(studentRepo.save((Student) any())).thenReturn(student);
        when(studentMapper.toDto((Student) any())).thenThrow(new StudentSurnameNotFound("Not all who wander are lost"));
        when(studentMapper.toEntity((StudentDto) any()))
                .thenThrow(new StudentSurnameNotFound("Not all who wander are lost"));

        StudentDto studentDto = new StudentDto();
        studentDto.setCourses(new ArrayList<>());
        studentDto.setCreated(LocalDateTime.of(1, 1, 1, 1, 1));
        studentDto.setId(123L);
        studentDto.setStudentName("Student Name");
        studentDto.setStudentSurname("Doe");
        studentDto.setUpdated(LocalDateTime.of(1, 1, 1, 1, 1));
        assertThrows(StudentSurnameNotFound.class, () -> studentServiceImpl.save(studentDto));
        verify(studentMapper).toEntity((StudentDto) any());
    }

    /**
     * Method under test: {@link StudentServiceImpl#get(Long)}
     */
    @Test
    void testGet() {
        Student student = new Student();
        student.setCourses(new ArrayList<>());
        student.setCreated(LocalDateTime.of(1, 1, 1, 1, 1));
        student.setId(123L);
        student.setStudentName("Student Name");
        student.setStudentSurname("Doe");
        student.setUpdated(LocalDateTime.of(1, 1, 1, 1, 1));
        Optional<Student> ofResult = Optional.of(student);
        when(studentRepo.findById((Long) any())).thenReturn(ofResult);

        StudentDto studentDto = new StudentDto();
        studentDto.setCourses(new ArrayList<>());
        studentDto.setCreated(LocalDateTime.of(1, 1, 1, 1, 1));
        studentDto.setId(123L);
        studentDto.setStudentName("Student Name");
        studentDto.setStudentSurname("Doe");
        studentDto.setUpdated(LocalDateTime.of(1, 1, 1, 1, 1));
        when(studentMapper.toDto((Student) any())).thenReturn(studentDto);
        assertSame(studentDto, studentServiceImpl.get(123L));
        verify(studentRepo).findById((Long) any());
        verify(studentMapper).toDto((Student) any());
    }

    /**
     * Method under test: {@link StudentServiceImpl#get(Long)}
     */
    @Test
    void testGet2() {
        Student student = new Student();
        student.setCourses(new ArrayList<>());
        student.setCreated(LocalDateTime.of(1, 1, 1, 1, 1));
        student.setId(123L);
        student.setStudentName("Student Name");
        student.setStudentSurname("Doe");
        student.setUpdated(LocalDateTime.of(1, 1, 1, 1, 1));
        Optional<Student> ofResult = Optional.of(student);
        when(studentRepo.findById((Long) any())).thenReturn(ofResult);
        when(studentMapper.toDto((Student) any())).thenThrow(new StudentSurnameNotFound("Not all who wander are lost"));
        assertThrows(StudentSurnameNotFound.class, () -> studentServiceImpl.get(123L));
        verify(studentRepo).findById((Long) any());
        verify(studentMapper).toDto((Student) any());
    }

    /**
     * Method under test: {@link StudentServiceImpl#getByNameAndSurname(String, String)}
     */
    @Test
    void testGetByNameAndSurname() {
        Student student = new Student();
        student.setCourses(new ArrayList<>());
        student.setCreated(LocalDateTime.of(1, 1, 1, 1, 1));
        student.setId(123L);
        student.setStudentName("Student Name");
        student.setStudentSurname("Doe");
        student.setUpdated(LocalDateTime.of(1, 1, 1, 1, 1));
        when(studentRepo.findStudentByStudentNameAndStudentSurname((String) any(), (String) any())).thenReturn(student);

        StudentDto studentDto = new StudentDto();
        studentDto.setCourses(new ArrayList<>());
        studentDto.setCreated(LocalDateTime.of(1, 1, 1, 1, 1));
        studentDto.setId(123L);
        studentDto.setStudentName("Student Name");
        studentDto.setStudentSurname("Doe");
        studentDto.setUpdated(LocalDateTime.of(1, 1, 1, 1, 1));
        when(studentMapper.toDto((Student) any())).thenReturn(studentDto);
        assertSame(studentDto, studentServiceImpl.getByNameAndSurname("Name", "Doe"));
        verify(studentRepo).findStudentByStudentNameAndStudentSurname((String) any(), (String) any());
        verify(studentMapper).toDto((Student) any());
    }

    /**
     * Method under test: {@link StudentServiceImpl#getByNameAndSurname(String, String)}
     */
    @Test
    void testGetByNameAndSurname2() {
        Student student = new Student();
        student.setCourses(new ArrayList<>());
        student.setCreated(LocalDateTime.of(1, 1, 1, 1, 1));
        student.setId(123L);
        student.setStudentName("Student Name");
        student.setStudentSurname("Doe");
        student.setUpdated(LocalDateTime.of(1, 1, 1, 1, 1));
        when(studentRepo.findStudentByStudentNameAndStudentSurname((String) any(), (String) any())).thenReturn(student);
        when(studentMapper.toDto((Student) any())).thenThrow(new StudentSurnameNotFound("Not all who wander are lost"));
        assertThrows(StudentSurnameNotFound.class, () -> studentServiceImpl.getByNameAndSurname("Name", "Doe"));
        verify(studentRepo).findStudentByStudentNameAndStudentSurname((String) any(), (String) any());
        verify(studentMapper).toDto((Student) any());
    }

    /**
     * Method under test: {@link StudentServiceImpl#getByStudentSurname(String)}
     */
    @Test
    void testGetByStudentSurname() {
        when(studentRepo.findByStudentSurname((String) any())).thenReturn(Optional.of(new ArrayList<>()));
        assertTrue(studentServiceImpl.getByStudentSurname("Doe").isEmpty());
        verify(studentRepo).findByStudentSurname((String) any());
    }

    /**
     * Method under test: {@link StudentServiceImpl#getByStudentSurname(String)}
     */
    @Test
    void testGetByStudentSurname2() {
        when(studentRepo.findByStudentSurname((String) any())).thenReturn(Optional.empty());
        when(studentMapper.toDto((Student) any())).thenThrow(new StudentSurnameNotFound("Not all who wander are lost"));
        assertThrows(StudentSurnameNotFound.class, () -> studentServiceImpl.getByStudentSurname("Doe"));
        verify(studentRepo).findByStudentSurname((String) any());
    }
}

