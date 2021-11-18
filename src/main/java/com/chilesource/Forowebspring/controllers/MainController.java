package com.chilesource.Forowebspring.controllers;

import com.chilesource.Forowebspring.model.User;
import com.chilesource.Forowebspring.service.*;
import org.springframework.beans.factory.annotation.Autowired;
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


    @RequestMapping("/")
    public String index(Model model, Principal p) {
        // Consultar todos los registros de categorias y supercategorias
        model.addAttribute("superCategories", superCategoryService.findAll());
        model.addAttribute("categories", categoryService.findAll());

        if (p != null) {
            // Logged user info
            int userId = userService.findByUserName(p.getName()).getId();
            model.addAttribute("userId", userId);
        }

        return "index";
    }

    @RequestMapping("/register")
    public String register(Model model, Principal p) {
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("user", new User());

        // FIXME: remplazar por redirect a otra página al ser usuario logeado
        if (p != null) {
            // Logged user info
            int userId = userService.findByUserName(p.getName()).getId();
            model.addAttribute("userId", userId);
        }

        return "register";
    }

    @PostMapping("/new-user")
    public String newUser(@ModelAttribute User user) {
        // Debug
        System.out.println(user);

        // Save
//        userService.saveUser(user);
        user.setProfilePicture("https://avatars.dicebear.com/api/initials/"+user.getUserName()+".svg");
        user.setPassword(encoder.encode(user.getPassword()));
        userService.save(user);

        // Debug
        System.out.println(user);
        return "redirect:/";
    }

    @RequestMapping("/404")
    public String error(Model model, Principal p) {
        model.addAttribute("superCategories", superCategoryService.findAll());
        model.addAttribute("categories", categoryService.findAll());

        if (p != null) {
            // Logged user info
            int userId = userService.findByUserName(p.getName()).getId();
            model.addAttribute("userId", userId);
        }

        return "404";
    }

}
