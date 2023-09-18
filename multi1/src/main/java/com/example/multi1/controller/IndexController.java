package com.example.multi1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.common.TestPrint;

@RestController
@RequestMapping("/multi1")
public class IndexController {
    @GetMapping("/")
    public String index() {
        return "Hello World";
    }

    @GetMapping("/print")
    public String print() {
        return (new TestPrint()).print();
    }
}
