package edu.miu.cs.cs425.studentmgmt.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;
    private String courseCode;
    private String courseName;
    @ManyToMany
    @JoinTable(name = "courses_students", joinColumns = {@JoinColumn(name = "course_id")}, inverseJoinColumns =
            {@JoinColumn(name = "student_id")})
    private List<Student> students;

    public Course() {
        students = new ArrayList<>();
    }

    public Course(Long courseId, String courseCode, String courseName, List<Student> students) {
        this.courseId = courseId;
        this.courseCode = courseCode;
        this.courseName = courseName;
        if(students == null){
            this.students = new ArrayList<>();
        }
        else this.students = students;
    }
}
