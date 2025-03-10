package com.zifan.todo.service;


import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * 2025, March 10, Monday, 6:34 AM
 */

@Service
public class TodoUserCredentials {

    public String getUsername() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}
