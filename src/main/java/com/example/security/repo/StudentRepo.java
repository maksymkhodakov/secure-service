package com.example.security.repo;

import com.example.security.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepo extends JpaRepository<Student, Long> {
    Student findStudentByStudentNameAndStudentSurname(String name, String surname);
    List<Student> findByStudentSurname(String surname);
}
