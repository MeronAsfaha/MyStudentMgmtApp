package edu.miu.cs.cs425.studentmgmt.service;

import edu.miu.cs.cs425.studentmgmt.model.Student;

import java.util.List;

public interface StudentService {
    Student saveStudent(Student newStudent);

    Student updateStudent(Student newStudent);

    void deleteById(Long studentId);

    Student getStudentById(Long studentId);

    List<Student> getAllStudents();


}
