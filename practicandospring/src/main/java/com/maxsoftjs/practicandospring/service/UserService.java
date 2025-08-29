package com.maxsoftjs.practicandospring.service;


import com.maxsoftjs.practicandospring.entity.User;
import com.maxsoftjs.practicandospring.repository.UserRepository;
import org.hibernate.sql.exec.ExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;



@Service
public class UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    private final UserRepository repo;
    public UserService(UserRepository repo){
        this.repo=repo;
    }

    public List<User> getAllUsers(){
        return repo.findAll();
    }

//    public User save(User user){
//        return repo.save(user);
//
//    }

    public User save(User userDetails) {
        User user = new User();
        try {
            if (!(userDetails.getUsername() == null) || !(userDetails.getPassword() == null) || !(userDetails.getRole() == null)) {
                user.setUsername(userDetails.getUsername());
                user.setPassword(passwordEncoder.encode(userDetails.getPassword()));
                user.setRole(userDetails.getRole());
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }

        return repo.save(user);
    }
    

    public void delete(Long id){
        repo.deleteById(id);
    }

    public User getUserById(Long id){
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    public User updateUser(Long id, User userDetails) {
        User user = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        try{
            if (!(userDetails.getUsername() == null) || !(userDetails.getPassword() == null) || !(userDetails.getRole()==null)){
                user.setUsername(userDetails.getUsername());
                user.setPassword(passwordEncoder.encode(userDetails.getPassword()));
                user.setRole(userDetails.getRole());
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }

        return repo.save(user);
    }


}
