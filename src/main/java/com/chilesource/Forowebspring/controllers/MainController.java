package com.chilesource.Forowebspring.controllers;

import com.chilesource.Forowebspring.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("categorias", categoryService.getAllCategories());
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
