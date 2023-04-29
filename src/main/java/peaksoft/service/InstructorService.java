package peaksoft.service;

import peaksoft.entity.Instructor;

import java.util.List;

public interface InstructorService {
    String saveInstructor(Instructor instructor);
    Instructor getInstructorById(Long id);
    Instructor updateInstructor(Long id,Instructor newInstructor);
    List<Instructor> getInstructorsByCourseId(Long courseId);
    void deleteInstructorById(Long id);
    String assignInstructorToCourse(Long instructorId,Long courseId);
}
