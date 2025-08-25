package com.maxsoftjs.practicandospring.service;

import com.maxsoftjs.practicandospring.entity.Task;
import com.maxsoftjs.practicandospring.repository.TaskRepository;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class TaskService {
    private final TaskRepository repo;
    public TaskService(TaskRepository repo){
        this.repo = repo;
    }

    public List<Task> getAllTasks(){
        return repo.findAll();
    }

    public Task save(Task task){
        return repo.save(task);

    }

    public void delete(Long id){
        repo.deleteById(id);
    }

    public Task getTaskById(Long id){
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found with id: " + id));
    }

    public Task updateTask(Long id, Task taskDetails) {
        Task task = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found with id: " + id));

        task.setTitle(taskDetails.getTitle());
        task.setDescription(taskDetails.getDescription());

        return repo.save(task);
    }




}
