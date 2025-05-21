package com.example.demo.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class HelloController {
    @GetMapping("/hello")
    public String hello(){
        return "Hello, World!";
    }
    @GetMapping("/query")
    public String printhelloquery(@RequestParam String name){
        return "Hello "+ name ;

    }
    @GetMapping("/{name}")
    public String printhellopath(@PathVariable String name){
        return "Hello new one"+ name ;
    }

}

