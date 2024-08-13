package com.spring.backend.Controller;
import com.spring.backend.Entity.Task;
import com.spring.backend.Entity.User;
import com.spring.backend.Service.TaskService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.spring.backend.Service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@CrossOrigin(origins = "http://localhost:4200")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("getTasks")
    public List<Task> getAllTasks() {
        System.out.println("Task list");

        System.out.println(taskService.getAllTasks());
        return taskService.getAllTasks();
    }

    @PostMapping("CreateTask")
    public Task createTask(@RequestBody Task task) {
        System.out.println("Task added");

        return taskService.createTask(task);

    }

    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task task) {
        task.setId(id);
        return taskService.updateTask(task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);

    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return taskService.getAllUsers();
    }

    @GetMapping("/tasks")
    public List<Task> getTasks() {
        return taskService.getAllTasks();
    }

    @Getter
    @Setter

    public static class AssignTaskRequest {
        private List<Long> taskIds;
        private String assignee;

    }

    @PutMapping("/tasks/assign")
    public ResponseEntity<Void> assignTasks(@RequestBody AssignTaskRequest request) {
        if (request.getTaskIds() == null || request.getTaskIds().isEmpty() || request.getAssignee() == null) {
            return ResponseEntity.badRequest().build();
        }
        taskService.assignTasks(request.getTaskIds(), request.getAssignee());
        return ResponseEntity.ok().build();
    }

}