package peaksoft.service.serviceImpl;

import peaksoft.entity.Instructor;
import peaksoft.repository.InstructorRepository;
import peaksoft.repository.repositoryImpl.InstructorRepositoryImpl;
import peaksoft.service.InstructorService;

import java.util.List;

public class InstructorServiceImpl implements InstructorService {
    InstructorRepository instructorRepository = new InstructorRepositoryImpl();
    @Override
    public String saveInstructor(Instructor instructor) {
        return instructorRepository.saveInstructor(instructor);
    }

    @Override
    public Instructor getInstructorById(Long id) {
        return instructorRepository.getInstructorById(id);
    }

    @Override
    public Instructor updateInstructor(Long id, Instructor newInstructor) {
        return instructorRepository.updateInstructor(id, newInstructor);
    }

    @Override
    public List<Instructor> getInstructorsByCourseId(Long courseId) {
        return instructorRepository.getInstructorsByCourseId(courseId);
    }

    @Override
    public void deleteInstructorById(Long id) {
instructorRepository.deleteInstructorById(id);
    }

    @Override
    public String assignInstructorToCourse(Long instructorId, Long courseId) {
        return instructorRepository.assignInstructorToCourse(instructorId, courseId);
    }
}
