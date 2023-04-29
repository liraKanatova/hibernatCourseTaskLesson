package peaksoft.service;

import peaksoft.entity.Task;

import java.util.List;

public interface TaskService {
    String saveTask( Task task);
    String assignTaskToLesson(Long taskId,Long lessonId);
    Task updateTask(Long id, Task task);
    List<Task> getAllTaskByLessonId(Long id);
    void deleteTaskById(Long id);
}
