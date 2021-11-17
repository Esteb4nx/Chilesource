package com.chilesource.Forowebspring.controllers;

import com.chilesource.Forowebspring.model.Role;
import com.chilesource.Forowebspring.model.User;
import com.chilesource.Forowebspring.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

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

//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        User user = userService.findByUserName(auth.getName());
//        model.addAttribute("user", user);

        return "index";
    }

    @RequestMapping("/favorites")
    public String favorites(Model model) {

        // Header component query
        model.addAttribute("categories", categoryService.findAll());

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
        // User role 1 por default (Ahora seteado en método saveUser)
//        user.setRoles(new HashSet<Role>(List.of(roleService.findById(2))));
//        user.setPassword(encoder.encode(user.getPassword()));
        userService.saveUser(user);

        return "redirect:/";
    }

//    @GetMapping("/login")
//    public String login(Model model) {
//        // Header component query
//        model.addAttribute("categories", categoryService.findAll());
//        return "login";
//    }

    @RequestMapping("/404")
    public String error(Model model) {
        model.addAttribute("superCategories", superCategoryService.findAll());
        model.addAttribute("categories", categoryService.findAll());

        return "404";
    }

}
