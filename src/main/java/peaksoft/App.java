package peaksoft;

import peaksoft.config.HibernateConfig;
import peaksoft.entity.Course;
import peaksoft.entity.Instructor;
import peaksoft.entity.Lesson;
import peaksoft.entity.Task;
import peaksoft.repository.TaskRepository;
import peaksoft.service.CourseService;
import peaksoft.service.InstructorService;
import peaksoft.service.LessonService;
import peaksoft.service.TaskService;
import peaksoft.service.serviceImpl.CourseServiceImpl;
import peaksoft.service.serviceImpl.InstructorServiceImpl;
import peaksoft.service.serviceImpl.LessonServiceImpl;
import peaksoft.service.serviceImpl.TaskServiceImpl;

import java.time.LocalDate;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        HibernateConfig.getEntityManager();
        CourseService courseService = new CourseServiceImpl();
//       System.out.println(courseService.saveCourse(new Course("java-11", 9, LocalDate.of(2023, 6, 3), "link3", "des3")));
//        System.out.println(courseService.getCourseById(3L));
//        System.out.println(courseService.getAllCourses());
//        System.out.println(courseService.updateCourse(3L, new Course("java-11", 8, LocalDate.of(2023, 6, 3), "link4", "des4")));
//       courseService.deleteCourseById(3L);
//        System.out.println(courseService.getCourseByName("java-8"));

        InstructorService instructorService = new InstructorServiceImpl();
//        System.out.println(instructorService.saveInstructor(new Instructor("Mukhammed", "m@gmail.com", "000111333")));
//        System.out.println(instructorService.getInstructorById(3L));
//        System.out.println(instructorService.updateInstructor(3L, new Instructor("Nuriza", "n@gmail.com", "333444555")));
//      System.out.println(instructorService.assignInstructorToCourse(1L, 2L));
//        System.out.println(instructorService.getInstructorsByCourseId(2L));
//        instructorService.deleteInstructorById(3L);

        LessonService lessonService = new LessonServiceImpl();
//        System.out.println(lessonService.saveLesson(1L,new Lesson("practiceProject", "link2")));
//        System.out.println(lessonService.updateLesson(1L,new Lesson("Spring","linkSprink")));
//        System.out.println(lessonService.getLessonByCourseName("java-9"));
//        System.out.println(lessonService.getLessonsByInstructorId(1L));
//        lessonService.deleteLessonById(2L);

        TaskService taskService = new TaskServiceImpl();
//        System.out.println(taskService.saveTask(new Task("Car", LocalDate.of(2023, 5, 29), "Jdbc")));
//       System.out.println(taskService.assignTaskToLesson(2L, 1L));
//        System.out.println(taskService.updateTask(1l, new Task("SpringBoot", LocalDate.of(2023, 5, 5), "FinalProject")));
     System.out.println(taskService.getAllTaskByLessonId(2L));
//        taskService.deleteTaskById(2L);
    }

}
