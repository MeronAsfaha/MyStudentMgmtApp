package edu.miu.cs.cs425.studentmgmt.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
@Getter
@ToString
@Setter

@Entity
@Table(name ="classrooms")
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long classroomId;
    private String buildingName;
    private String roomNumber;
    @OneToMany(mappedBy = "classroom")
    private List<Student> students;

    public Classroom() {
        students = new ArrayList<>();
    }

    public Classroom(Long classroomId, String buildingName, String roomNumber, List<Student> students) {
        this.classroomId = classroomId;
        this.buildingName = buildingName;
        this.roomNumber = roomNumber;
        if(students == null){
            this.students = new ArrayList<>();
        }
        else this.students = students;
    }
}
