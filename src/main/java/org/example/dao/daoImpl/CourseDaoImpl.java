package org.example.dao.daoImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.example.config.HibernateConfig;
import org.example.dao.CourseDao;
import org.example.entity.Course;

import java.util.List;

public class CourseDaoImpl implements CourseDao,AutoCloseable {
    EntityManagerFactory entityManagerFactory = HibernateConfig.getEntityManager();

    public String saveCourse(Course newCourse) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(newCourse);
        entityManager.getTransaction().commit();
        entityManager.close();
        return newCourse + " successfully saved";
    }

    public Course getCourseById(Long id) {
      EntityManager entityManager = entityManagerFactory.createEntityManager();
      entityManager.getTransaction().begin();
        Course id1 =(Course) entityManager.createQuery("select c from Course c  where c.id = :id",Course.class)
                .setParameter("id", id)
                .getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return id1;
    }




    public String updateCourse(Long oldId, Course newCourse) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Course id = entityManager.createQuery("select c from Course c where c.id= :id", Course.class)
                .setParameter("id", oldId)
                .getSingleResult();
        id.setCourseName(newCourse.getCourseName());
        id.setPrice(newCourse.getPrice());
//        int i = entityManager.createQuery("update Course c set c.courseName=:courseName,c.price=:price where c.id=:oldId")
//                .setParameter("courseName", newCourse.getCourseName())
//                .setParameter("price", newCourse.getPrice())
//                .setParameter("old", oldId).executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Course with id: "+oldId+" successfully update! "+id;
    }

    @Override
    public List<Course> getAllCourses() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Course> resultList = entityManager.createQuery("select c from Course c ", Course.class)
                .getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return resultList;
    }



    public String deleteCourseById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Course course = entityManager.find(Course.class, id);
        entityManager.remove(course);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "successfully deleted";
    }

    @Override
    public void close() throws Exception {
        entityManagerFactory.close();
    }
}
