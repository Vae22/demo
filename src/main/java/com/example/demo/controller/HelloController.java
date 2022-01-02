package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liminghao.
 * @date 2021/12/5
 * @time 16:21
 */
@RestController
public class HelloController {
    @GetMapping("/hello1")
    public String hello() {
        return "Hello";
    }
}
