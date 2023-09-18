package com.example.multi2.controller;

import com.example.common.TestPrint;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/multi2")
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
