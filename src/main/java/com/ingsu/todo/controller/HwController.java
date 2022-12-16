package com.ingsu.todo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HwController {
    @GetMapping("/")
    public String helloWorld(){
        return "To do Application !";
    }
}
