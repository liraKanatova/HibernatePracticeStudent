package org.example.service.serviceImpl;

import org.example.dao.StudentDao;
import org.example.dao.daoImpl.StudentDaoImpl;
import org.example.entity.Student;
import org.example.enums.Gender;
import org.example.service.StudentService;

import java.util.List;
import java.util.Map;

public class StudentServiceImpl implements StudentService {
    StudentDao studentDao = new StudentDaoImpl();
    {

    }

    @Override
    public String saveStudent(Student student) {
        return studentDao.saveStudent(student);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentDao.getStudentById(id);
    }

    @Override
    public String updateStudentById(Long id, Student newstudent) {
        return studentDao.updateStudentById(id, newstudent);
    }

    @Override
    public List<Student> getAllSortedStudentsStudents() {
        return studentDao.getAllSortedStudentsStudents();
    }

    @Override
    public String deleteStudentById(Long id) {
        return studentDao.deleteStudentById(id);
    }

    @Override
    public Map<Gender, List<Student>> groupByGender(String maleOrFemale) {
        return studentDao.groupByGender(maleOrFemale);
    }

    @Override
    public Student getOldOrYoungerStudent() {
        return studentDao.getOldOrYoungerStudent();
    }

    @Override
    public Student findStudentByFirstName(String name) {
        return studentDao.findStudentByFirstName(name);
    }
}
