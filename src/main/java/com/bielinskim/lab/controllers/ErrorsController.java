package com.bielinskim.lab.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorsController {

    @GetMapping("/error403")
    public String loginForm() {
        return "errors/forbidden";
    }

}
