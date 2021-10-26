package com.chilesource.Forowebspring.controllers;

import com.chilesource.Forowebspring.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/post/{id}")
    public String post(@PathVariable int id, Model modelo){
        modelo.addAttribute("post", postService.findById(id));

        return  "post";
    }
}
