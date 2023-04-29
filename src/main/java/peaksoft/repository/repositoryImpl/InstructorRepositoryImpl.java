package peaksoft.repository.repositoryImpl;

import jakarta.persistence.EntityManager;
import peaksoft.config.HibernateConfig;
import peaksoft.entity.Course;
import peaksoft.entity.Instructor;
import peaksoft.repository.InstructorRepository;

import java.util.List;

public class InstructorRepositoryImpl implements InstructorRepository
{
    private final EntityManager entityManager = HibernateConfig.getEntityManager();
    @Override
    public String saveInstructor(Instructor instructor) {
        entityManager.getTransaction().begin();
        entityManager.persist(instructor);
        entityManager.getTransaction().commit();
        entityManager.close();
        return instructor.getInstructorName()+" is saved";
    }

    @Override
    public Instructor getInstructorById(Long id) {
        entityManager.getTransaction().begin();
        Instructor id1 = entityManager.createQuery("select i from Instructor i where i.id=:id", Instructor.class)
                .setParameter("id", id)
                .getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return id1;
    }

    @Override
    public Instructor updateInstructor(Long id, Instructor newInstructor) {
        entityManager.getTransaction().begin();
        Instructor id1 = entityManager.createQuery("select i from Instructor i where i.id=:id", Instructor.class)
                .setParameter("id", id)
                .getSingleResult();
        id1.setInstructorName(newInstructor.getInstructorName());
        id1.setEmail(newInstructor.getEmail());
        id1.setPhoneNumber(newInstructor.getPhoneNumber());
        entityManager.getTransaction().commit();
        entityManager.close();
        return id1;
    }

    @Override
    public List<Instructor> getInstructorsByCourseId(Long courseId) {
        entityManager.getTransaction().begin();
        List<Instructor> instructors = entityManager.createQuery("select i from Instructor i join i.courses c where c.id=:courseId", Instructor.class)
                .setParameter("courseId", courseId)
                .getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return instructors;
    }

    @Override
    public void deleteInstructorById(Long id) {
        entityManager.getTransaction().begin();
        Instructor instructor = entityManager.createQuery("select i from Instructor i where i.id=:id", Instructor.class)
                .setParameter("id", id)
                .getSingleResult();
        instructor.getCourses().forEach(x->x.setInstructors(null));
        entityManager.remove(instructor);
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println(instructor.getInstructorName()+ " is deleted");

    }

    @Override
    public String assignInstructorToCourse(Long instructorId, Long courseId) {
        entityManager.getTransaction().begin();
        Instructor instructor = entityManager.find(Instructor.class, instructorId);
        Course course = entityManager.find(Course.class, courseId);
        instructor.getCourses().add(course);
        course.getInstructors().add(instructor);
        entityManager.getTransaction().commit();
        entityManager.close();
        return instructor.getInstructorName()+ " assign to "+course.getCourseName();
    }
}
