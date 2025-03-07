package com.zifan.todo.login;


/**
 * 2025, March 01, Saturday, 9:58 PM
 */

public class AuthenticationService {
    public static boolean authenticate(String username, String password) {
        return username.equals("nafiz") && password.equals("123");
    }
}
