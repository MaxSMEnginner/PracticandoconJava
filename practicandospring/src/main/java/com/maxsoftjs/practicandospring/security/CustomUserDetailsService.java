package com.maxsoftjs.practicandospring.security;


import com.maxsoftjs.practicandospring.entity.User;
import com.maxsoftjs.practicandospring.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;




@Service
public class CustomUserDetailsService implements UserDetailsService{
    private final UserRepository repo;


    public CustomUserDetailsService(UserRepository repo){
        this.repo=repo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        User user = repo.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Not found Username: "+ username));

        String role = user.getRole() ? "ROLE_ADMIN" : "ROLE_USER";

        List<GrantedAuthority> authorities= List.of(new SimpleGrantedAuthority(role));


        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                authorities
        );
    }




}


