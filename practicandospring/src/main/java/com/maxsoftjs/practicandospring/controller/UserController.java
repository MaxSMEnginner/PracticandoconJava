package com.maxsoftjs.practicandospring.controller;

import com.maxsoftjs.practicandospring.entity.User;
import com.maxsoftjs.practicandospring.entity.User;
import com.maxsoftjs.practicandospring.service.UserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;
import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service){
        this.service= service;
    }


    // todos veran las tareas
    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<User> getAllUsers(){
        return service.getAllUsers();
    }


    //Admin podra crear tareas(luego agregaremos seguridad)
    @PostMapping
    public User createdUser(@RequestBody User user){
        return service.save(user);

    }

    //Admin podra eliminar tareas(luego agregaremos seguridad)
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void deleteUser(@PathVariable Long id){
        service.delete(id);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public User getUserById(@PathVariable Long id){
        return service.getUserById(id);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public User updateUser(@PathVariable Long id,@RequestBody User userDetails){
        return service.updateUser(id, userDetails);

    }






}
