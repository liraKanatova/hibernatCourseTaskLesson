package peaksoft.repository.repositoryImpl;

import jakarta.persistence.EntityManager;
import peaksoft.config.HibernateConfig;
import peaksoft.entity.Course;
import peaksoft.entity.Lesson;
import peaksoft.entity.Task;
import peaksoft.repository.TaskRepository;

import java.util.List;

public class TaskRepositoryImpl implements TaskRepository {
    private final EntityManager entityManager = HibernateConfig.getEntityManager();
    @Override
    public String saveTask( Task task) {
        entityManager.getTransaction().begin();
        entityManager.persist(task);
        entityManager.getTransaction().commit();
        entityManager.close();
        return task.getName()+ " is saved";
    }

    @Override
    public String assignTaskToLesson(Long taskId, Long lessonId) {
        entityManager.getTransaction().begin();
        Task task = entityManager.find(Task.class, taskId);
        Lesson lesson = entityManager.find(Lesson.class, lessonId);
      if(task==null){
          return "Task not found";
      }
      if(lesson== null){
          return "Lesson not found";
      }
       task.setLesson(lesson);
      entityManager.persist(task);
        entityManager.getTransaction().commit();
        entityManager.close();
        return null;
    }

    @Override
    public Task updateTask(Long id, Task newTask) {
        entityManager.getTransaction().begin();
        Task task1 = entityManager.find(Task.class, id);
        task1.setName(newTask.getName());
        task1.setDeadline(newTask.getDeadline());
        task1.setTaskDescription(newTask.getTaskDescription());
        entityManager.getTransaction().commit();
        entityManager.close();
        return task1;
    }

    @Override
    public List<Task> getAllTaskByLessonId(Long id) {
        entityManager.getTransaction().begin();
        List<Task> tasks = entityManager.createQuery("select t from Task t join t.lesson l  where l.id=:id", Task.class)
                .setParameter("id", id)
                .getResultList();
        entityManager.getTransaction().begin();
        entityManager.close();
        return tasks;
    }

    @Override
    public void deleteTaskById(Long id) {
        entityManager.getTransaction().begin();
        Task task = entityManager.find(Task.class, id);
        entityManager.remove(task);
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println(task.getName()+" is delete.. ");

    }
}
