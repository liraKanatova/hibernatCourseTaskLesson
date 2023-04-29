package peaksoft.repository.repositoryImpl;

import jakarta.persistence.EntityManager;
import peaksoft.config.HibernateConfig;
import peaksoft.entity.Course;
import peaksoft.repository.CourseRepository;

import java.util.List;

public class CourseRepositoryImpl implements CourseRepository {
    private final EntityManager entityManager = HibernateConfig.getEntityManager();
    @Override
    public String saveCourse(Course course) {
        entityManager.getTransaction().begin();
        entityManager.persist(course);
        entityManager.getTransaction().commit();
        entityManager.close();
        return course.getCourseName()+" is saved";
    }

    @Override
    public Course getCourseById(Long id) {
        entityManager.getTransaction().begin();
        Course result = entityManager.createQuery("select c from Course c where c.id=:id", Course.class)
                .setParameter("id", id)
                .getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return result ;
    }

    @Override
    public List<Course> getAllCourses() {
        entityManager.getTransaction().begin();
        List<Course> list = entityManager.createQuery("select c from Course c ", Course.class)
                .getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return list;
    }

    @Override
    public String updateCourse(Long id, Course newCourse) {
        entityManager.getTransaction().begin();
        Course result = entityManager.createQuery("select c from Course c where c.id=:id", Course.class)
                .setParameter("id", id)
                .getSingleResult();
        result.setCourseName(newCourse.getCourseName());
        result.setDuration(newCourse.getDuration());
        result.setDateOfStart(newCourse.getDateOfStart());
        result.setImageLink(newCourse.getImageLink());
        result.setDescription(newCourse.getDescription());
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Course with id: "+id+" successfully update! "+result;
    }

    @Override
    public void deleteCourseById(Long id) {
        entityManager.getTransaction().begin();
        Course course = entityManager.find(Course.class, id);
        entityManager.remove(course);
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println("Course with id: "+id+ " deleted");

    }

    @Override
    public Course getCourseByName(String name) {
        entityManager.getTransaction().begin();
        Course name1 = entityManager.createQuery("select c from Course c where c.courseName=:name", Course.class)
                .setParameter("name", name)
                .getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return name1;
    }
}
