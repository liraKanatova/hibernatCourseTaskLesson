package peaksoft.repository;

import peaksoft.entity.Instructor;

import java.util.List;

public interface InstructorRepository {
    String saveInstructor(Instructor instructor);
    Instructor getInstructorById(Long id);
    Instructor updateInstructor(Long id,Instructor instructor);
    List<Instructor> getInstructorsByCourseId(Long courseId);
    void deleteInstructorById(Long id);
        String assignInstructorToCourse(Long instructorId,Long courseId);
}
