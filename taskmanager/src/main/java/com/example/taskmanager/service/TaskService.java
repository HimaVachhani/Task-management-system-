package com.example.taskmanager.service;

import com.example.taskmanager.entity.Task;
import com.example.taskmanager.entity.TaskStatus;
import com.example.taskmanager.entity.User;
import com.example.taskmanager.repository.TaskRepository;
import com.example.taskmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    public List<Task> getTasksByCreator(Long creatorId) {
        Optional<User> user = userRepository.findById(creatorId);
        return user.map(taskRepository::findByCreatedBy).orElse(List.of());
    }

    public List<Task> getTasksByAssignee(Long assigneeId) {
        Optional<User> user = userRepository.findById(assigneeId);
        return user.map(taskRepository::findByAssignedTo).orElse(List.of());
    }

    public List<Task> getTasksByStatus(TaskStatus status) {
        return taskRepository.findByStatus(status);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
