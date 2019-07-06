package com.ups.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
public class LoginController {

    @RequestMapping(value = "/login")
    public String sayHello() {
        return "Hello world!";
    }
}
