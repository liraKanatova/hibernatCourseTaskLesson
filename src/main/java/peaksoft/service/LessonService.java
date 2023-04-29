package peaksoft.service;

import peaksoft.entity.Lesson;

import java.util.List;
import java.util.Map;

public interface LessonService {
    Lesson saveLesson(Long courseId, Lesson lesson);

    Lesson updateLesson(Long id, Lesson lesson);

    List<Lesson> getLessonByCourseName(String name);

    // Lesson chygaryp jatkanda, lesson kaisy kurska tiesheluu bolso oshol kurstun aty chogu chyksyn
    Map<Lesson, String> getLessonsByInstructorId(Long instructorId);


    void deleteLessonById(Long id);
}
