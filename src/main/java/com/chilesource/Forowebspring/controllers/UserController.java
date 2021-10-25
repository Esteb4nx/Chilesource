package com.chilesource.Forowebspring.controllers;

import com.chilesource.Forowebspring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/profile/{id}")
    public String profile(@PathVariable int id, Model modelo){


        modelo.addAttribute("user",userService.findById(id));

        return "profile";
    }
}
