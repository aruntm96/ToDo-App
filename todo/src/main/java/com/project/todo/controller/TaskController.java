package com.project.todo.controller;

import com.project.todo.model.Task;
import com.project.todo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/tasks")
public class TaskController {
    @Autowired
    private TaskRepository taskRepository;
    @PostMapping
    public Task CreateTask(@RequestBody Task task){
        taskRepository.save(task);
        return task;
    }

    @GetMapping
    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    @PutMapping("/{id}")
    public Task UpdateTask(@PathVariable Long id, @RequestBody Task task){
        task.setId(id);
        return taskRepository.save(task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id){
        taskRepository.deleteById(id);
    }
}
