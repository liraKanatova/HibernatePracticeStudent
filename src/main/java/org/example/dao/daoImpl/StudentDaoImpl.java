package org.example.dao.daoImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.example.config.HibernateConfig;
import org.example.dao.StudentDao;
import org.example.entity.Student;
import org.example.enums.Gender;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentDaoImpl implements StudentDao,AutoCloseable {
EntityManagerFactory entityManagerFactory = HibernateConfig.getEntityManager();
    @Override
    public String saveStudent(Student student) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(student);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Successfully saved!";
    }

    @Override
    public Student getStudentById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Student result = entityManager.createQuery("select s from Student s where s.id=:id", Student.class)
                .setParameter("id", id)
                .getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return result;
    }

    @Override
    public String updateStudentById(Long id, Student newstudent) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Student result = entityManager.createQuery("select s from Student s where s.id=:id", Student.class)
                .setParameter("id", id)
                .getSingleResult();
        result.setFirstName(newstudent.getFirstName());
        result.setLastName(newstudent.getLastName());
        result.setEmail(newstudent.getEmail());
        result.setAge(newstudent.getAge());
        result.setGender(newstudent.getGender());
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Successfully updated "+result;
    }

    @Override
    public List<Student> getAllSortedStudentsStudents() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Student> resultList = entityManager.createQuery("select s from Student s order by s.firstName ", Student.class)
                .getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return resultList;
    }

    @Override
    public String deleteStudentById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Student result = entityManager.createQuery("select  s from Student  s where s.id=:id", Student.class)
                .setParameter("id", id)
                .getSingleResult();
        entityManager.remove(result);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Successfully deleted";
    }

    @Override
    public Map<Gender, List<Student>> groupByGender(String maleOrFemale) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Map<Gender, List<Student>> map = entityManager.createQuery("select s from Student s ", Student.class)
                .getResultStream().collect(Collectors.groupingBy(Student::getGender));
        entityManager.getTransaction().commit();
        entityManager.close();
        return  map;
    }

    @Override
    public Student getOldOrYoungerStudent() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Student student = entityManager.createQuery("select s from Student s order by s.age desc limit 1", Student.class)
                .getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return student;
    }

    @Override
    public Student findStudentByFirstName(String name) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Student firstName = entityManager.createQuery("select s from Student s where s.firstName=:firstName", Student.class)
                .setParameter("firstName", name)
                .getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return firstName;
    }

    @Override
    public void close() throws Exception {
        entityManagerFactory.close();
    }
}

