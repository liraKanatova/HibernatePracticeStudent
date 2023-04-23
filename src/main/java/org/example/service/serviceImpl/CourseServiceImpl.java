package org.example.service.serviceImpl;

import org.example.dao.CourseDao;
import org.example.dao.daoImpl.CourseDaoImpl;
import org.example.entity.Course;
import org.example.service.CourseService;

import java.util.List;

public class CourseServiceImpl implements CourseService {
    CourseDao courseDao = new CourseDaoImpl();
    public String saveCourse(Course newCourse) {
        return courseDao.saveCourse(newCourse);
    }

    public Course getCourseById(Long id) {
        return courseDao.getCourseById(id);
    }

    public String updateCourse(Long oldId, Course newCourse) {
        return courseDao.updateCourse(oldId, newCourse);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseDao.getAllCourses();
    }



    public String deleteCourseById(Long id) {
        return courseDao.deleteCourseById(id);
    }
}
