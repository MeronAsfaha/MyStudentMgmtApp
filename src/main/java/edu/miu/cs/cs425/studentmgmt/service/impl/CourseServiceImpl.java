package edu.miu.cs.cs425.studentmgmt.service.impl;

import edu.miu.cs.cs425.studentmgmt.model.Course;
import edu.miu.cs.cs425.studentmgmt.repository.CourseRepository;
import edu.miu.cs.cs425.studentmgmt.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;

    @Override
    public Course addNewCourse(Course newCourse) {
        return courseRepository.save(newCourse);
    }

    @Override
    public Course getCourseById(Long courseId) {
        return courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course doesn't exist"));
    }

    @Override
    public void deleteById(Long courseId) {
        courseRepository.deleteById(courseId);
    }

    @Override
    public Course updateCourse(Course newCourse) {
        getCourseById(newCourse.getCourseId());
        return courseRepository.save(newCourse);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }


}
