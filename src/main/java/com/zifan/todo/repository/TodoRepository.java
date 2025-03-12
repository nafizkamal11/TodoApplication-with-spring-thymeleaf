package com.zifan.todo.repository;


import com.zifan.todo.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * 2025, March 12, Wednesday, 5:43 AM
 */
public interface TodoRepository extends JpaRepository<Todo, Integer> {
    List<Todo> findByUsername(String username);
}
