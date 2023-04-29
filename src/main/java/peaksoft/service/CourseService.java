package peaksoft.service;

import peaksoft.entity.Course;

import java.util.List;

public interface CourseService {
    String saveCourse(Course course);
    Course getCourseById(Long id);
    List<Course> getAllCourses();
    String updateCourse(Long id,Course course);
    void deleteCourseById(Long id);
    Course getCourseByName(String name);
}
