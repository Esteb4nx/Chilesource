package com.chilesource.Forowebspring.controllers;


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
    private PostService postService;

    @GetMapping
    public String main(@RequestParam(value = "id") int id, Model model) {
        model.addAttribute("post", postService.findById(id));

        return  "post";
    }

    // Corresponde a ruta /post/edit
    @GetMapping("/edit")
    public String editPostForm(@RequestParam(value = "id") int id, Model model) {
        model.addAttribute("post", postService.findById(id));

        return  "edit-post";
    }

<<<<<<< HEAD



=======
    @PostMapping("/edit-post")
    public String editPostSubmit(@ModelAttribute Post post){
        postService.save(post);

        return "redirect:/";
    }

//    @PostMapping
//    public String saveCommentary(Commentary commentary, Post post, Model model) {
//        model.addAttribute("post", postService.findById())
//        commentaryService.save(commmentary);
//        return "post";
//    }
>>>>>>> 47c3bb1472600dcefa162f9b81fe48cc3bc4da78
}
