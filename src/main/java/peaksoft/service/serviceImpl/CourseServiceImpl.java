package peaksoft.service.serviceImpl;

import peaksoft.entity.Course;
import peaksoft.repository.CourseRepository;
import peaksoft.repository.repositoryImpl.CourseRepositoryImpl;
import peaksoft.service.CourseService;

import java.util.List;

public class CourseServiceImpl implements CourseService {
    CourseRepository courseService = new CourseRepositoryImpl();
    @Override
    public String saveCourse(Course course) {
        return courseService.saveCourse(course);
    }

    @Override
    public Course getCourseById(Long id) {
        return courseService.getCourseById(id);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @Override
    public String updateCourse(Long id, Course course) {
        return courseService.updateCourse(id, course);
    }

    @Override
    public void deleteCourseById(Long id) {
    courseService.deleteCourseById(id);
    }

    @Override
    public Course getCourseByName(String name) {
        return courseService.getCourseByName(name);
    }
}
