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
@Table(name = "courses")
public class Course extends AbstractEntity {
    private String courseName;
    private String teacherName;
    private Collection<Student> students;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    public Collection<Student> getStudents() {
        return students;
    }

    @Column(name = "name")
    public String getCourseName() {
        return courseName;
    }

    @Column(name = "teacher_name")
    public String getTeacherName() {
        return teacherName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Course course = (Course) o;

        if (getCourseName() != null ? !getCourseName().equals(course.getCourseName()) : course.getCourseName() != null)
            return false;
        if (getTeacherName() != null ? !getTeacherName().equals(course.getTeacherName()) : course.getTeacherName() != null)
            return false;
        return getStudents() != null ? getStudents().equals(course.getStudents()) : course.getStudents() == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getCourseName() != null ? getCourseName().hashCode() : 0);
        result = 31 * result + (getTeacherName() != null ? getTeacherName().hashCode() : 0);
        result = 31 * result + (getStudents() != null ? getStudents().hashCode() : 0);
        return result;
    }
}
