package peaksoft.service.serviceImpl;

import peaksoft.entity.Lesson;
import peaksoft.repository.LessonRepository;
import peaksoft.repository.repositoryImpl.LessonRepositoryImpl;
import peaksoft.service.LessonService;

import java.util.List;
import java.util.Map;

public class LessonServiceImpl implements LessonService {
    LessonRepository lessonRepository = new LessonRepositoryImpl();
    @Override
    public Lesson saveLesson(Long courseId, Lesson lesson) {
        return lessonRepository.saveLesson(courseId, lesson);
    }

    @Override
    public Lesson updateLesson(Long id, Lesson lesson) {
        return lessonRepository.updateLesson(id, lesson);
    }

    @Override
    public List<Lesson> getLessonByCourseName(String name) {
        return lessonRepository.getLessonByCourseName(name);
    }

    @Override
    public Map<Lesson, String> getLessonsByInstructorId(Long instructorId) {
        return lessonRepository.getLessonsByInstructorId(instructorId);
    }

    @Override
    public void deleteLessonById(Long id) {
    lessonRepository.deleteLessonById(id);
    }
}
