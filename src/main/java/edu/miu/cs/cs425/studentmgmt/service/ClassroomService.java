package edu.miu.cs.cs425.studentmgmt.service;

import edu.miu.cs.cs425.studentmgmt.model.Classroom;

import java.util.List;

public interface ClassroomService {
    Classroom addNewClassroom(Classroom newClassroom);
    Classroom getClassroomById(Long classroomId);
    List<Classroom> getAllClassrooms();
    Classroom updateClassroom(Classroom newClassroom);
    void deleteById(Long classroomId);
}
