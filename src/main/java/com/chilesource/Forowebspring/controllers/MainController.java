package com.chilesource.Forowebspring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    //@Autowired
    //private ServicioCateogias categorias;

    @RequestMapping("/")
    public String index(){

        return "index";
    }

    @RequestMapping("/profile")
    public String profile(){

        return "profile";
    }

    @RequestMapping("/favorites")
    public String favorites(){

        return "favorites";
    }

    @RequestMapping("/new-post")
    public String newPost(){

        return "new-post";
    }

    @GetMapping("/post")
    //@PathVariable("id") int id
    public String post(){

        return "post";
    }

    @GetMapping("/forum")
    //@PathVariable("id") int id
    public String forum(){

        return "forum";
    }

    @RequestMapping("/register")
    public String register(){

        return "register";
    }

}
