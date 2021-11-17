package com.chilesource.Forowebspring.controllers;

import com.chilesource.Forowebspring.service.CategoryService;
import com.chilesource.Forowebspring.service.PostService;
import com.chilesource.Forowebspring.service.SuperCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private SuperCategoryService superCategoryService;

    @Autowired
    private PostService postService;

    @RequestMapping("/")
    public String index(Model model) {
        // Consultar todos los registros
        model.addAttribute("superCategories", superCategoryService.findAll());
        model.addAttribute("categories", categoryService.findAll());

        return "index";
    }

    @RequestMapping("/favorites")
    public String favorites(Model model) {

        // Header component query
        model.addAttribute("categories", categoryService.findAll());

        return "favorites";
    }

    @RequestMapping("/register")
    public String register() {

        return "register";
    }

    @RequestMapping("/404")
    public String error(Model model) {
        model.addAttribute("superCategories", superCategoryService.findAll());
        model.addAttribute("categories", categoryService.findAll());

        return "404";
    }

}
