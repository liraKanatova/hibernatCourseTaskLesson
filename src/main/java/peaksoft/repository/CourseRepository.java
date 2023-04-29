package peaksoft.repository;

import peaksoft.entity.Course;

import java.util.List;

public interface CourseRepository {
    String saveCourse(Course course);
    Course getCourseById(Long id);
    List<Course> getAllCourses();
    String updateCourse(Long id,Course course);
    void deleteCourseById(Long id);
    Course getCourseByName(String name);
}
