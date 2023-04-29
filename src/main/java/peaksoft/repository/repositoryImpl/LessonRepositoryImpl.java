package peaksoft.repository.repositoryImpl;

import jakarta.persistence.EntityManager;
import peaksoft.config.HibernateConfig;
import peaksoft.entity.Course;
import peaksoft.entity.Lesson;
import peaksoft.repository.LessonRepository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LessonRepositoryImpl implements LessonRepository {
    private final EntityManager entityManager = HibernateConfig.getEntityManager();
    @Override
    public Lesson saveLesson(Long courseId, Lesson lesson) {
        entityManager.getTransaction().begin();
        Course course = entityManager.find(Course.class, courseId);
        entityManager.persist(lesson);
        course.getLessons().add(lesson);
        lesson.setCourse(course);
        entityManager.getTransaction().commit();
        entityManager.close();
        return lesson;
    }

    @Override
    public Lesson updateLesson(Long id, Lesson lesson) {
        entityManager.getTransaction().begin();
        Lesson lesson1 = entityManager.find(Lesson.class, id);
        lesson1.setLessonName(lesson.getLessonName());
        lesson1.setVideoLink(lesson.getVideoLink());
        entityManager.getTransaction().commit();
        entityManager.close();
        return lesson1;
    }

    @Override
    public List<Lesson> getLessonByCourseName(String name) {
        entityManager.getTransaction().begin();
        List<Lesson> courseName = entityManager.createQuery("select l from Lesson l join l.course c where c.courseName=:name", Lesson.class)
                .setParameter("name", name)
                .getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return courseName;
    }

    @Override
    public Map<Lesson, String> getLessonsByInstructorId(Long instructorId) {
        entityManager.getTransaction().begin();
        List<Lesson> resultList = entityManager.createQuery("select l from Lesson l where l.id=:instructorId ", Lesson.class)
                .setParameter("instructorId", instructorId)
                .getResultList();
        Map<Lesson,String> lessonStringMap = new HashMap<>();
        for (Lesson lesson : resultList) {
            lessonStringMap.put(lesson,lesson.getLessonName());
        }
        entityManager.getTransaction().commit();
        entityManager.close();
        return lessonStringMap;
    }

    @Override
    public void deleteLessonById(Long id) {
        entityManager.getTransaction().begin();
        Lesson lesson = entityManager.find(Lesson.class, id);
        entityManager.remove(lesson);
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println(lesson.getLessonName()+ " is deleted");

    }
}
