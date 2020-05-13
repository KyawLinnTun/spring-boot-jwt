package com.example.springbootjwt.controller;

import com.example.springbootjwt.repository.TaskRepository;
import com.example.springbootjwt.task.Task;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskRepository taskRepository;

    public TaskController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @PostMapping
    public void createTask(@RequestBody Task task){
        this.taskRepository.save(task);
    }

    @GetMapping
    public List<Task> showallTasks(){
        return this.taskRepository.findAll();
    }

    @PutMapping("/{id}")
    public void updateTask(@RequestBody Task task,@PathVariable long id){
        Task existingTask = this.taskRepository.findById(id).get();
        existingTask.setDescription(task.getDescription());
         this.taskRepository.save(existingTask);

    }

    @DeleteMapping("/{id}")
    public void removeTask(long id){
      this.taskRepository.delete(this.taskRepository.getOne(id));
    }

}
