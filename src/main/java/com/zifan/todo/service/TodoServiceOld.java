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
public class TodoServiceOld {
    private TodoRepository repository;

    public TodoServiceOld(TodoRepository repository) {
        this.repository = repository;
    }

    private static List<Todo> todoList = new ArrayList<>();

    @Getter
    private static int todoCount = 1;

    static {
        todoList.add(new Todo(todoCount++, "nafiz", "Learn AWS", LocalDate.now().plusYears(1), false));
        todoList.add(new Todo(todoCount++, "kamal", "Learn DevOps", LocalDate.now().plusYears(2), false));
        todoList.add(new Todo(todoCount++, "nafiz", "Learn Spring", LocalDate.now().plusYears(1), true));
    }

    public List<Todo> findByUsername(String username) {
        return todoList.stream().filter(todo -> todo.getUsername().equals(username)).toList();
    }

    public List<Todo> getAllTodos() {
        return todoList
                .stream()
                .sorted(Comparator.comparing(Todo::getId))
                .toList();
    }

    public void addTodo(Todo todo) {
        todo.setId(todoCount++);
        todoList.add(todo);
    }

    public Optional<Todo> findById(int id) {
        return todoList.stream()
                .filter(todo1 -> todo1.getId() == id)
                .findFirst();
    }

    public void deleteById(int id) {
        findById(id).ifPresent(todo -> todoList.remove(todo));
    }

    public void update(@Valid Todo todo) {
        deleteById(todo.getId());
        todoList.add(todo);
    }
}
