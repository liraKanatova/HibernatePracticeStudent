package org.example.dao;

import org.example.entity.Course;

import java.util.List;

public interface CourseDao {
    String saveCourse(Course newCourse);

    Course getCourseById(Long id);

    String updateCourse(Long oldId, Course newCourse);

    List<Course> getAllCourses();

    String deleteCourseById(Long id);
}
