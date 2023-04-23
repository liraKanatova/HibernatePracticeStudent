package org.example.service;

import org.example.entity.Course;

import java.util.List;

public interface CourseService {
    String saveCourse(Course newCourse);

    Course getCourseById(Long id);

    String updateCourse(Long oldId, Course newCourse);

    List<Course> getAllCourses();

    String deleteCourseById(Long id);
}
