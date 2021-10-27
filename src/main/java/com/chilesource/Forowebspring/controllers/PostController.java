package com.chilesource.Forowebspring.controllers;


import com.chilesource.Forowebspring.model.Post;
import com.chilesource.Forowebspring.service.CategoryService;
import com.chilesource.Forowebspring.service.CommentaryService;
import com.chilesource.Forowebspring.service.PostService;
import com.chilesource.Forowebspring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping("/post")
public class PostController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private PostService postService;

    @GetMapping
    public String main(@RequestParam(value = "id") int id, Model model) {
        model.addAttribute("post", postService.findById(id));

        // Header component query
        model.addAttribute("categories", categoryService.findAll());

        return  "post";
    }

    // Corresponde a ruta /post/edit
    @GetMapping("/edit")
    public String editPostForm(@RequestParam(value = "id") int id, Model model) {
        model.addAttribute("post", postService.findById(id));

        // Header component query
        model.addAttribute("categories", categoryService.findAll());

        return  "edit-post";
    }

    @PostMapping("/edit-post")
    public String editPostSubmit(@ModelAttribute Post post){
        postService.save(post);

        return "redirect:/";
    }

    @RequestMapping("/delete")
    public String deletePost(@RequestParam(value = "id") int id, Model model) {
        postService.deleteById(id);
        return "redirect:/";
    }


}
