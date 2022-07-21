package com.example.security.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Table(name = "students")
public class Student extends AbstractEntity {
    private String studentName;
    private String studentSurname;
    private Collection<Course> courses;

    @Column(name = "student_surname")
    public String getStudentSurname() {
        return studentSurname;
    }

    @Column(name = "student_name")
    public String getStudentName() {
        return studentName;
    }

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    public Collection<Course> getCourses() {
        return courses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Student student = (Student) o;

        if (getStudentName() != null ? !getStudentName().equals(student.getStudentName()) : student.getStudentName() != null)
            return false;
        if (getStudentSurname() != null ? !getStudentSurname().equals(student.getStudentSurname()) : student.getStudentSurname() != null)
            return false;
        return getCourses() != null ? getCourses().equals(student.getCourses()) : student.getCourses() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getStudentName() != null ? getStudentName().hashCode() : 0);
        result = 31 * result + (getStudentSurname() != null ? getStudentSurname().hashCode() : 0);
        result = 31 * result + (getCourses() != null ? getCourses().hashCode() : 0);
        return result;
    }
}
