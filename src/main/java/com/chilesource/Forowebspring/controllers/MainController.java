package com.chilesource.Forowebspring.controllers;

import com.chilesource.Forowebspring.model.Role;
import com.chilesource.Forowebspring.model.User;
import com.chilesource.Forowebspring.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private SuperCategoryService superCategoryService;

    @Autowired
    private BCryptPasswordEncoder encoder;


    public String currentUserName(Principal p) {
        return p.getName();
    }


    @RequestMapping("/")
    public String index(Model model) {
        // Consultar todos los registros
        model.addAttribute("superCategories", superCategoryService.findAll());
        model.addAttribute("categories", categoryService.findAll());

        // Otra forma de obtener info del usuario logeado (distinta a la utilizada en PostController.java)
        // Fuentes: https://www.baeldung.com/get-user-in-spring-security
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        int userId = userService.findByUserName(auth.getName()).getId();
        model.addAttribute("userId", userId);

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
    public String newUser(@ModelAttribute User user) {
        // Debug
        System.out.println(user);

        // Save
//        userService.saveUser(user);
        user.setPassword(encoder.encode(user.getPassword()));
        userService.save(user);

        // Debug
        System.out.println(user);
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
