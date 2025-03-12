package com.zifan.todo.service;


import com.zifan.todo.model.Todo;
import com.zifan.todo.repository.TodoRepository;
import jakarta.validation.Valid;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * 2025, March 02, Sunday, 5:49 AM
 */

@Service
public class TodoService {
    private TodoRepository repository;

    public TodoService(TodoRepository repository) {
        this.repository = repository;
    }

    public List<Todo> getAllTodos() {
        return repository.findAll().stream().sorted(Comparator.comparing(Todo::getId)).toList();
    }

    public List<Todo> findByUsername(String username) {
        return repository.findByUsername(username).stream().sorted(Comparator.comparing(Todo::getId)).toList();
    }

    public Optional<Todo> findById(int id) {
        return repository.findById(id);
    }

    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public void addTodo(Todo todo) {
        repository.save(todo);
    }

    public void update(Todo todo) {
        repository.save(todo);
    }
}
