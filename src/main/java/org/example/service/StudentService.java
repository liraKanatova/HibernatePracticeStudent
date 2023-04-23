package org.example.service;

import org.example.entity.Student;
import org.example.enums.Gender;

import java.util.List;
import java.util.Map;

public interface StudentService {
    String saveStudent(Student student);

    Student getStudentById(Long id);

    String updateStudentById(Long id, Student newstudent);

    List<Student> getAllSortedStudentsStudents();

    String deleteStudentById(Long id);

    Map<Gender, List<Student>> groupByGender(String maleOrFemale);

    Student getOldOrYoungerStudent();

    Student findStudentByFirstName(String name);

}
