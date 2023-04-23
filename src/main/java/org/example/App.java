package org.example;

import org.example.entity.Course;
import org.example.entity.Student;
import org.example.enums.Gender;
import org.example.service.CourseService;
import org.example.service.StudentService;
import org.example.service.serviceImpl.CourseServiceImpl;
import org.example.service.serviceImpl.StudentServiceImpl;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        CourseService courseService = new CourseServiceImpl();
//        System.out.println(courseService.saveCourse(new Course("Java-8",12000)));
//        System.out.println(courseService.getCourseById(1L));
//        System.out.println(courseService.updateCourse(1L, new Course("Java-9", 8000)));
//        System.out.println(courseService.getAllCourses());

        StudentService service = new StudentServiceImpl();
//    System.out.println(service.saveStudent(new Student("Nuriza", "Muratova", "n@gmail.com", 17,Gender.FEMALE)));
//        System.out.println(service.getStudentById(1L));
//        System.out.println(service.updateStudentById(1L ,new Student("Saltanat", "Nimat k", "s@gmail.com", 21)));
//       System.out.println(service.deleteStudentById(3L));
//       System.out.println(service.findStudentByFirstName("Ilim"));
//        System.out.println(service.getOldOrYoungerStudent());
//        System.out.println(service.getAllSortedStudentsStudents());
//        System.out.println(service.groupByGender("Gender.FEMALE"));
    }
}
