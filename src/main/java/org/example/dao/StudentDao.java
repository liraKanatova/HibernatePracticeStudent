package org.example.dao;

import org.example.entity.Student;
import org.example.enums.Gender;

import java.util.List;
import java.util.Map;

public interface StudentDao {
    String saveStudent(Student student);

    Student getStudentById(Long id);

    String updateStudentById(Long id, Student student);

    List<Student> getAllSortedStudentsStudents();

    String deleteStudentById(Long id);

    Map<Gender, List<Student>> groupByGender(String maleOrFemale);

    Student getOldOrYoungerStudent();

    Student findStudentByFirstName(String name);
}
