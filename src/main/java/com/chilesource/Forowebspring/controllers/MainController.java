package com.chilesource.Forowebspring.controllers;

import com.chilesource.Forowebspring.model.User;
import com.chilesource.Forowebspring.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private SuperCategoryService superCategoryService;

    @Autowired
    private PostService postService;

    @Autowired
    private RoleService roleService;


    @RequestMapping("/")
    public String index(Model model) {
        // Consultar todos los registros
        model.addAttribute("superCategories", superCategoryService.findAll());
        model.addAttribute("categories", categoryService.findAll());

        return "index";
    }

    @RequestMapping("/favorites")
    public String favorites() {

        return "favorites";
    }

    @RequestMapping("/register")
    public String register(Model model) {
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("user", new User());


        return "register";
    }

    @PostMapping("/new-user")
    public String newUser(@ModelAttribute User user){
        user.setRole(roleService.findById(1));
        userService.save(user);

        return "redirect:/";
    }


    @RequestMapping("/404")
    public String error(Model model) {
        model.addAttribute("superCategories", superCategoryService.findAll());
        model.addAttribute("categories", categoryService.findAll());

        return "404";
    }

}
