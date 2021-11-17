package com.chilesource.Forowebspring.controllers;

import com.chilesource.Forowebspring.model.Post;
import com.chilesource.Forowebspring.model.User;
import com.chilesource.Forowebspring.service.CategoryService;
import com.chilesource.Forowebspring.service.PostService;
import com.chilesource.Forowebspring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
public class UserController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    @GetMapping("/profile")
    public String profile(@RequestParam(value = "id") int id, Model model, Principal p){

        User user = userService.findById(id);
        boolean isAuthor = false;

        if (p != null) {
            isAuthor = p.getName().equals(user.getUserName());


            int userId = userService.findByUserName(p.getName()).getId();
            model.addAttribute("userId", userId);
        }

        if(user != null){
            model.addAttribute("isAuthor", isAuthor);
            model.addAttribute("user",user);
            model.addAttribute("posts", postService.findAllByAuthorIdOrderByDateAsc(id));
            model.addAttribute("categories", categoryService.findAll());

            return "profile";
        }else{
            model.addAttribute("categories", categoryService.findAll());
            return "404";
        }

    }
}
