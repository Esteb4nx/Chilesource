package com.chilesource.Forowebspring.controllers;

import com.chilesource.Forowebspring.service.PostService;
import com.chilesource.Forowebspring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    @GetMapping("/profile")
    public String profile(@RequestParam(value = "id") int id, Model modelo){
        modelo.addAttribute("user",userService.findById(id));
        modelo.addAttribute("posts", postService.findAllByAuthorIdOrderByDateAsc(id));

        return "profile";
    }
}
