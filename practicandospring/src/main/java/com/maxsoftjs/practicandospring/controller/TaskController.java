package com.maxsoftjs.practicandospring.controller;


import com.maxsoftjs.practicandospring.entity.Task;
import com.maxsoftjs.practicandospring.service.TaskService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService service;


    public TaskController(TaskService service){
        this.service= service;
    }

    // todos veran las tareas
    @GetMapping
    public List<Task> getAllTasks(){
        return service.getAllTasks();
    }


    //Admin podra crear tareas(luego agregaremos seguridad)
    @PostMapping
    public Task createdTask(@RequestBody Task task){
        return service.save(task);

    }

    //Admin podra eliminar tareas(luego agregaremos seguridad)
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteTask(@PathVariable Long id){
        service.delete(id);
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id){
        return service.getTaskById(id);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public Task updateTask(@PathVariable Long id,@RequestBody Task taskDetails){
        return service.updateTask(id, taskDetails);

    }




}
