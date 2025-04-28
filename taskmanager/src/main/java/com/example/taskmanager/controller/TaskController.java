package com.example.taskmanager.controller;

import com.example.taskmanager.entity.Task;
import com.example.taskmanager.entity.TaskStatus;
import com.example.taskmanager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public Optional<Task> getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    @GetMapping("/creator/{creatorId}")
    public List<Task> getTasksByCreator(@PathVariable Long creatorId) {
        return taskService.getTasksByCreator(creatorId);
    }

    @GetMapping("/assignee/{assigneeId}")
    public List<Task> getTasksByAssignee(@PathVariable Long assigneeId) {
        return taskService.getTasksByAssignee(assigneeId);
    }

    @GetMapping("/status")
    public List<Task> getTasksByStatus(@RequestParam TaskStatus status) {
        return taskService.getTasksByStatus(status);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }
}
