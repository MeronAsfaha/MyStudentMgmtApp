package edu.miu.cs.cs425.studentmgmt.service;

import edu.miu.cs.cs425.studentmgmt.model.Course;

import java.util.List;

public interface CourseService {
    Course addNewCourse(Course newCourse);

    Course getCourseById(Long courseId);

    void deleteById(Long courseId);

    Course updateCourse(Course newCourse);

    List<Course> getAllCourses();

}

