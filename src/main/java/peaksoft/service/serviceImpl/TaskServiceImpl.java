package peaksoft.service.serviceImpl;

import peaksoft.entity.Task;
import peaksoft.repository.TaskRepository;
import peaksoft.repository.repositoryImpl.TaskRepositoryImpl;
import peaksoft.service.TaskService;

import java.util.List;

public class TaskServiceImpl implements TaskService {
    TaskRepository taskRepository = new TaskRepositoryImpl();
    @Override
    public String saveTask( Task task) {
        return taskRepository.saveTask( task);
    }

    @Override
    public String assignTaskToLesson(Long taskId, Long lessonId) {
        return taskRepository.assignTaskToLesson(taskId, lessonId);
    }

    @Override
    public Task updateTask(Long id, Task task) {
        return taskRepository.updateTask(id, task);
    }

    @Override
    public List<Task> getAllTaskByLessonId(Long id) {
        return taskRepository.getAllTaskByLessonId(id);
    }

    @Override
    public void deleteTaskById(Long id) {
     taskRepository.deleteTaskById(id);
    }
}
