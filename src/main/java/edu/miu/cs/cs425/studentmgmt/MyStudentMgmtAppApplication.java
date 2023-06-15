package edu.miu.cs.cs425.studentmgmt;

import edu.miu.cs.cs425.studentmgmt.model.Classroom;
import edu.miu.cs.cs425.studentmgmt.model.Course;
import edu.miu.cs.cs425.studentmgmt.model.Student;
import edu.miu.cs.cs425.studentmgmt.model.Transcript;
import edu.miu.cs.cs425.studentmgmt.service.ClassroomService;
import edu.miu.cs.cs425.studentmgmt.service.CourseService;
import edu.miu.cs.cs425.studentmgmt.service.StudentService;
import edu.miu.cs.cs425.studentmgmt.service.TranscriptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class MyStudentMgmtAppApplication implements CommandLineRunner {

    @Autowired
    private StudentService studentService;
    @Autowired
    private TranscriptService transcriptService;
    @Autowired
    private ClassroomService classroomService;
    @Autowired
    private CourseService courseService;

    public static void main(String[] args) {
        SpringApplication.run(MyStudentMgmtAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Starting MyStudentMgmt App...");
        var student1 = new Student(null,"000-61-0001","Anna",
                "Lynn", "Smith", 3.45, LocalDate.of(2019,5,24),
                null,null,null);
        var student2 = new Student(null,"000-11-1111", "John", "Doe", "Smith", 3.2, LocalDate.of(2020,7,14),
               null,null,null);

        var savedStudent1 = studentService.saveStudent(student1);
        var savedStudent2 = studentService.saveStudent(student2);
        System.out.println(savedStudent1);
        List<Student> students = new ArrayList<>(Arrays.asList(savedStudent1,savedStudent2));
        var transcript1 = new Transcript(null, "BS Computer Science", savedStudent1);
        var transcript2 = new Transcript(null,"Mathematics",savedStudent2);
        var course1 = new Course(null, "CS 201", "Procedural Programing", students);
        var classroom1 = new Classroom(null, "Mclaughlin Bldg", "M115", students);

        var savedTranscript1 = transcriptService.addTranscript(transcript1);
        var savedTranscript2 = transcriptService.addTranscript(transcript2);
        var savedClassroom1 = classroomService.addNewClassroom(classroom1);
        var savedCourse1 = courseService.addNewCourse(course1);
        List<Course> courses = new ArrayList<>(Arrays.asList(savedCourse1));

        savedStudent1.setTranscript(savedTranscript1);
        savedStudent1.setCourses(courses);
        savedStudent1.setClassroom(savedClassroom1);
        savedStudent2.setClassroom(savedClassroom1);
        savedStudent2.setCourses(courses);
        savedStudent2.setTranscript(savedTranscript2);

        studentService.updateStudent(savedStudent1);
        studentService.updateStudent(savedStudent2);

    }
}
