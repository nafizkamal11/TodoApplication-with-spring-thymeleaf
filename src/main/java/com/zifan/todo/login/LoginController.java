package com.zifan.todo.login;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * 2025, March 01, Saturday, 6:51 PM
 */

@Controller
@SessionAttributes("username")
public class LoginController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping("/login")
    public String getLoginPage() {
        return "login/login";
    }

    @PostMapping("/login")
    public String getWelcomePage(@RequestParam String username, @RequestParam String password, Model model) {
        logger.info("Welcome " + username + " " + password);
        if(AuthenticationService.authenticate(username, password)) {
            model.addAttribute("username", username);
            return "login/welcome";
        }

        model.addAttribute("error", "invalid credentials, try again...");
        return "login/login";
    }
}
