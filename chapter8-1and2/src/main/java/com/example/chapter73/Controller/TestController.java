package com.example.chapter73.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @RequestMapping("/get")
    public String get(){
        return "hello1";
    }
}
