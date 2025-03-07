package com.zifan.todo.myTodo;


import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/**
 * 2025, March 02, Sunday, 5:57 AM
 */

@Controller
@SessionAttributes("username")
public class TodoController {
    private TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/todo")
    public String getAllTodo(Model model) {
        model.addAttribute("todoList", todoService.getAllTodos().stream().sorted(Comparator.comparing(Todo::getId)).toList());
        return "todo/todo";
    }

    @GetMapping("/todo/add")
    public String getAddTodo(Model model) {
        Todo todo = new Todo();
        todo.setId(TodoService.getTodoCount());
        todo.setUsername(model.getAttribute("username").toString());
        todo.setTargetDate(LocalDate.now().plusYears(1));
        model.addAttribute("todo", todo);
        model.addAttribute("todoList", todoService.getAllTodos());
        return "todo/add";
    }

    @PostMapping("/todo/add")
    public String todoAdd(@Valid @ModelAttribute Todo todo, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("todoList", todoService.getAllTodos());
            System.out.println(bindingResult.getFieldError());
            return "/todo/add";
        }

        todoService.addTodo(todo);
        return "redirect:/todo";
    }


    @GetMapping("/todo/delete")
    public String deleteTodo(@RequestParam int id) {
        todoService.deleteById(id);
        return "redirect:/todo";
    }

    @GetMapping("/todo/update")
    public String getUpdateTodoPage(@RequestParam int id, Model model) {
        model.addAttribute("firstHalf", todoService.getAllTodos()
                .stream()
                .filter(todo2 -> todo2.getId() < id)
                .toList());

        model.addAttribute("todo", todoService.findById(id).get());

        model.addAttribute("lastHalf", todoService.getAllTodos()
                .stream()
                .filter(todo -> todo.getId() > id)
                .toList());

        return "/todo/update";
    }

    @PostMapping("/todo/update")
    public String updateTodo(@Valid @ModelAttribute Todo todo, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
//            model.addAttribute("todoList", todoService.getAllTodos());
            model.addAttribute("firstHalf", todoService.getAllTodos()
                    .stream()
                    .filter(todo2 -> todo2.getId() < todo.getId())
                    .toList());
            model.addAttribute("lastHalf", todoService.getAllTodos()
                    .stream()
                    .filter(todo1 -> todo1.getId() > todo.getId())
                    .toList());

            System.out.println(bindingResult.getFieldError());
            return "/todo/update";
        }

        todoService.update(todo);
        return "redirect:/todo";
    }

}
