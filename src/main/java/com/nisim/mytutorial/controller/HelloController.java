package com.nisim.mytutorial.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String helloWorld(){
        System.out.println("hh");
        System.out.println("hhddd");
        return "Welcome to nisim tutorial ! !!!!! ";

    }

}
