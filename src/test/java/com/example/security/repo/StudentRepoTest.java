package com.example.security.repo;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.security.domain.Student;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration(classes = {StudentRepo.class})
@EnableAutoConfiguration
@EntityScan(basePackages = {"com.example.security.domain"})
@DataJpaTest(properties = {"spring.main.allow-bean-definition-overriding=true"})
class StudentRepoTest {
    @Autowired
    private StudentRepo studentRepo;

    /**
     * Method under test: {@link StudentRepo#findStudentByStudentNameAndStudentSurname(String, String)}
     */
    @Test
    void testFindStudentByStudentNameAndStudentSurname() {
        Student student = new Student();
        student.setCourses(new ArrayList<>());
        student.setCreated(LocalDateTime.of(1, 1, 1, 1, 1));
        student.setStudentName("Student Name");
        student.setStudentSurname("Doe");
        student.setUpdated(LocalDateTime.of(1, 1, 1, 1, 1));

        Student student1 = new Student();
        student1.setCourses(new ArrayList<>());
        student1.setCreated(LocalDateTime.of(1, 1, 1, 1, 1));
        student1.setStudentName("Student Name");
        student1.setStudentSurname("Doe");
        student1.setUpdated(LocalDateTime.of(1, 1, 1, 1, 1));
        studentRepo.save(student);
        studentRepo.save(student1);
        assertNull(studentRepo.findStudentByStudentNameAndStudentSurname("foo", "foo"));
    }

    /**
     * Method under test: {@link StudentRepo#findByStudentSurname(String)}
     */
    @Test
    void testFindByStudentSurname() {
        Student student = new Student();
        student.setCourses(new ArrayList<>());
        student.setCreated(LocalDateTime.of(1, 1, 1, 1, 1));
        student.setStudentName("Student Name");
        student.setStudentSurname("Doe");
        student.setUpdated(LocalDateTime.of(1, 1, 1, 1, 1));

        Student student1 = new Student();
        student1.setCourses(new ArrayList<>());
        student1.setCreated(LocalDateTime.of(1, 1, 1, 1, 1));
        student1.setStudentName("Student Name");
        student1.setStudentSurname("Doe");
        student1.setUpdated(LocalDateTime.of(1, 1, 1, 1, 1));
        studentRepo.save(student);
        studentRepo.save(student1);
        assertTrue(studentRepo.findByStudentSurname("foo").isPresent());
    }
}

