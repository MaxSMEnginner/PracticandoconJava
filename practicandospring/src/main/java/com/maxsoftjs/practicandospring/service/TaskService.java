package com.maxsoftjs.practicandospring.service;


import com.maxsoftjs.practicandospring.entity.Task;
import com.maxsoftjs.practicandospring.repository.TaskRepository;
import org.springframework.stereotype.Service;
import com.maxsoftjs.practicandospring.entity.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import com.maxsoftjs.practicandospring.repository.UserRepository;



import java.util.List;


@Service
public class TaskService {
    private final TaskRepository repo;

    private final UserRepository userRepository;

    public TaskService(TaskRepository repo, UserRepository userRepository){
        this.repo = repo;
        this.userRepository= userRepository;


    }

    public List<Task> getAllTasks(){
        return repo.findAll();
    }

    public Task save(Task task){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String name= auth.getName();

        User user= userRepository.findByUsername(name)
                .orElseThrow(()-> new RuntimeException("Username not found"+ name));

        task.setUser(user);


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
