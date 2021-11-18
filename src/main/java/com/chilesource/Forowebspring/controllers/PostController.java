package com.chilesource.Forowebspring.controllers;


import com.chilesource.Forowebspring.model.Commentary;
import com.chilesource.Forowebspring.model.Post;
import com.chilesource.Forowebspring.service.CategoryService;
import com.chilesource.Forowebspring.service.CommentaryService;
import com.chilesource.Forowebspring.service.PostService;
import com.chilesource.Forowebspring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Date;

@Controller
@RequestMapping("/post")
public class PostController {
    @Autowired
    private UserService userService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private PostService postService;

    @Autowired
    private CommentaryService commentaryService;

    @GetMapping
    public String main(@RequestParam(value = "id") int id, Model model, Principal p) {
        Post post = postService.findById(id);
        // Se necesita la var fuera para el caso del user guest
        boolean isAuthor = false;

        if (p != null) {
            isAuthor = p.getName().equals(post.getAuthor().getUserName());
            // Logged user info
            int userId = userService.findByUserName(p.getName()).getId();
            model.addAttribute("userId", userId);
        }

        if(post != null){
            model.addAttribute("post", post);
            model.addAttribute("isAuthor", isAuthor);

            // Header component query
            model.addAttribute("categories", categoryService.findAll());

            //Comentarios
            model.addAttribute("commentaries", commentaryService.findAllByPostIdOrderByDateAsc(id));

            return "post";
        }else{
            model.addAttribute("categories", categoryService.findAll());
            return "404";
        }

    }

    // Corresponde a ruta /post/edit
    @GetMapping("/edit")
    public String editPostForm(@RequestParam(value = "id") int id, Model model, Principal p) {
        model.addAttribute("post", postService.findById(id));

        // Header component query
        model.addAttribute("categories", categoryService.findAll());

        if (p != null) {
            // Logged user info
            int userId = userService.findByUserName(p.getName()).getId();
            model.addAttribute("userId", userId);
        }

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

    //Comentarios
    @PostMapping("/new-comment")
    public String newComment(@ModelAttribute Commentary commentary, Principal p){
        Date date = new Date();
        java.sql.Timestamp sqlTimeStamp = new java.sql.Timestamp(date.getTime());
        commentary.setDate(sqlTimeStamp);

        if (p != null) {
            // Logged user info
            commentary.setUser(userService.findByUserName(p.getName()));
        }

        commentaryService.save(commentary);
        return "redirect:/post?id="+ commentary.getPost().getId();
    }


}
