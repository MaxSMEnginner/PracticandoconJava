package com.maxsoftjs.practicandospring.repository;

import com.maxsoftjs.practicandospring.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TaskRepository extends JpaRepository<Task, Long>{


}
