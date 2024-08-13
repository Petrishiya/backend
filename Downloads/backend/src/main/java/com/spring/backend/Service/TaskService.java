package com.spring.backend.Service;
import com.spring.backend.Entity.Task;
import com.spring.backend.Entity.User;
import com.spring.backend.Repository.TaskRepository;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.backend.Repository.UserRepository;
import java.util.List;

@Service
@Table(name="TASKS")
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;


    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task createTask(Task task)
    {
        return taskRepository.save(task);
    }

    public Task updateTask(Task task)

    {
        return taskRepository.save(task);
    }

    public void deleteTask(Long id)
    {
        taskRepository.deleteById(id);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }



    public void assignTasks(List<Long> taskIds, String username) {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            List<Task> tasks = taskRepository.findAllById(taskIds);
            tasks.forEach(task -> task.setAssignee(username));
            taskRepository.saveAll(tasks);
        }
    }
}