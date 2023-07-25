package com.attrabit.wellax.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/page")
public class ViewController {
    @GetMapping()
    public String home(Model model){
        return "index";
    }
    @GetMapping("/login")
    public String login(Model model){
        return "login";
    }
}
