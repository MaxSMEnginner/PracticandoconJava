package com.maxsoftjs.practicandospring.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableMethodSecurity
public class SecurityConfig {
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config)throws Exception{
        return config.getAuthenticationManager();

    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        // todos pueden listar y ver tareas
                        .requestMatchers(HttpMethod.GET, "/tasks", "/tasks/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/tasks").permitAll()
                        // registro de usuarios público
                        .requestMatchers(HttpMethod.POST, "/users").permitAll()
                        // todo lo demás requiere login
                        .anyRequest().authenticated()
                )
                .httpBasic(basic -> basic.realmName("APIS"));

        return http.build();
    }

}






