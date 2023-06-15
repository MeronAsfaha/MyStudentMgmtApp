package edu.miu.cs.cs425.studentmgmt.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@ToString

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;
    @NotNull(message = "Student number field can't be null")
    @NotEmpty(message = "student number field can't be empty")
    private String studentNumber;
    @NotNull(message = "Student first name field can't be null")
    @NotEmpty(message = "student first name field can't be empty")
    private String firstName;
    private String middleName;
    @NotNull(message = "Student last name field can't be null")
    @NotEmpty(message = "student last name field can't be empty")
    private String lastName;
    private double cgpa;
    private LocalDate dateOfEnrollment;
    @ManyToOne
    @JoinColumn(name = "classroom_id")
    private Classroom classroom;
    @OneToOne
    @JoinColumn(name = "transcript_id")
    private Transcript transcript;
    @ManyToMany (mappedBy = "students")
    private List<Course> courses = new ArrayList<>();

    public Student(Long studentId, @NotNull(message = "Student number field can't be null") String studentNumber, @NotNull(message = "Student first name field can't be null") String firstName, String middleName, @NotNull(message = "Student last name field can't be null") String lastName, double cgpa,
                   LocalDate dateOfEnrollment, Classroom classroom, Transcript transcript, List<Course> courses) {
        this.studentId = studentId;
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.cgpa = cgpa;
        this.dateOfEnrollment = dateOfEnrollment;
        this.classroom = classroom;
        this.transcript = transcript;
        if(courses != null){
            this.courses = courses;
        }
    }
}
