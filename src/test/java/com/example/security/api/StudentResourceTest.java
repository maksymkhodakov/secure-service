package com.example.security.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.security.DTO.StudentDto;
import com.example.security.domain.Student;
import com.example.security.repo.StudentRepo;
import com.example.security.service.implementations.StudentServiceImpl;
import com.example.security.service.StudentService;
import com.example.security.utils.mapper.StudentMapper;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {StudentResource.class})
@ExtendWith(SpringExtension.class)
class StudentResourceTest {
    @Autowired
    private StudentResource studentResource;

    @MockBean
    private StudentService studentService;

    /**
     * Method under test: {@link StudentResource#get(Long)}
     */
    @Test
    void testGet() throws Exception {
        StudentDto studentDto = new StudentDto();
        studentDto.setCourses(new ArrayList<>());
        studentDto.setCreated(LocalDateTime.of(1, 1, 1, 1, 1));
        studentDto.setId(123L);
        studentDto.setStudentName("Student Name");
        studentDto.setStudentSurname("Doe");
        studentDto.setUpdated(LocalDateTime.of(1, 1, 1, 1, 1));
        when(studentService.get((Long) any())).thenReturn(studentDto);
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/students/get_student");
        MockHttpServletRequestBuilder requestBuilder = getResult.param("id", String.valueOf(1L));
        MockMvcBuilders.standaloneSetup(studentResource)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":123,\"created\":\"0001-01-01 01:01:00.000\",\"updated\":\"0001-01-01 01:01:00.000\",\"studentName\":\"Student"
                                        + " Name\",\"studentSurname\":\"Doe\",\"courses\":[]}"));
    }

    /**
     * Method under test: {@link StudentResource#getStudentByNameAndSurname(String, String)}
     */
    @Test
    void testGetStudentByNameAndSurname() throws Exception {
        StudentDto studentDto = new StudentDto();
        studentDto.setCourses(new ArrayList<>());
        studentDto.setCreated(LocalDateTime.of(1, 1, 1, 1, 1));
        studentDto.setId(123L);
        studentDto.setStudentName("Student Name");
        studentDto.setStudentSurname("Doe");
        studentDto.setUpdated(LocalDateTime.of(1, 1, 1, 1, 1));
        when(studentService.getByNameAndSurname((String) any(), (String) any())).thenReturn(studentDto);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/students/get_student_by_name_and_surname")
                .param("name", "foo")
                .param("surname", "foo");
        MockMvcBuilders.standaloneSetup(studentResource)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"id\":123,\"created\":\"0001-01-01 01:01:00.000\",\"updated\":\"0001-01-01 01:01:00.000\",\"studentName\":\"Student"
                                        + " Name\",\"studentSurname\":\"Doe\",\"courses\":[]}"));
    }

    /**
     * Method under test: {@link StudentResource#getStudentListBySurname(String)}
     */
    @Test
    void testGetStudentListBySurname() throws Exception {
        when(studentService.getByStudentSurname((String) any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/students/{surname}", "Doe");
        MockMvcBuilders.standaloneSetup(studentResource)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link StudentResource#getStudentListBySurname(String)}
     */
    @Test
    void testGetStudentListBySurname2() throws Exception {
        when(studentService.getByStudentSurname((String) any())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/api/students/{surname}", "Doe");
        getResult.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(studentResource)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    /**
     * Method under test: {@link StudentResource#save(StudentDto)}
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
        StudentRepo studentRepo = mock(StudentRepo.class);
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
        StudentMapper studentMapper = mock(StudentMapper.class);
        when(studentMapper.toDto((Student) any())).thenReturn(studentDto);
        when(studentMapper.toEntity((StudentDto) any())).thenReturn(student1);
        StudentResource studentResource = new StudentResource(new StudentServiceImpl(studentRepo, studentMapper));

        StudentDto studentDto1 = new StudentDto();
        studentDto1.setCourses(new ArrayList<>());
        studentDto1.setCreated(LocalDateTime.of(1, 1, 1, 1, 1));
        studentDto1.setId(123L);
        studentDto1.setStudentName("Student Name");
        studentDto1.setStudentSurname("Doe");
        studentDto1.setUpdated(LocalDateTime.of(1, 1, 1, 1, 1));
        ResponseEntity<StudentDto> actualSaveResult = studentResource.save(studentDto1);
        assertEquals(studentDto1, actualSaveResult.getBody());
        assertTrue(actualSaveResult.getHeaders().isEmpty());
        assertEquals(HttpStatus.OK, actualSaveResult.getStatusCode());
        verify(studentRepo).save((Student) any());
        verify(studentMapper).toDto((Student) any());
        verify(studentMapper).toEntity((StudentDto) any());
    }
}

