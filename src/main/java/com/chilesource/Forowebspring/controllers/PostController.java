package com.chilesource.Forowebspring.controllers;

import com.chilesource.Forowebspring.model.Commentary;
import com.chilesource.Forowebspring.service.CommentaryService;
import com.chilesource.Forowebspring.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @Autowired
    private CommentaryService commentaryService;

    @GetMapping
    public String main(@RequestParam(value = "id") int id, Model model) {
        model.addAttribute("post", postService.findById(id));
        model.addAttribute("commentary", new Commentary());

        return  "post";
    }

    // Corresponde a ruta /post/edit
    @GetMapping("/edit")
    public String editPost(@RequestParam(value = "id") int id, Model modelo) {
        modelo.addAttribute("post", postService.findById(id));

        return  "edit-post";
    }

//    @PostMapping
//    public String saveCommentary(Commentary commentary, Post post, Model model) {
//        model.addAttribute("post", postService.findById())
//        commentaryService.save(commmentary);
//        return "post";
//    }
}
