package com.zifan.todo.hello;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 2025, March 01, Saturday, 6:51 PM
 */

@Controller
public class HelloController {

    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello() {
        return "Hello World";
    }

    @RequestMapping("/hello-html")
    @ResponseBody
    public String sayHelloHtml() {
        return """
                <!DOCTYPE html>
                <html>
                <head>
                <meta charset="UTF-8">
                <title>Hello World</title>
                </head>
                <body>
                <h1>Hello World</h1>
                </body>              
                """;
    }

    @RequestMapping("/hello-thymeleaf")
    public String sayHelloThymeleaf() {
        return "hello/hello";
    }
}
