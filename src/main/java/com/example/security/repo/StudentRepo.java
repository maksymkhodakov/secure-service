package com.example.security.repo;

import com.example.security.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface StudentRepo extends JpaRepository<Student, Long> {
    Student findStudentByStudentNameAndStudentSurname(String name, String surname);
    Optional<List<Student>> findByStudentSurname(String surname);
}
