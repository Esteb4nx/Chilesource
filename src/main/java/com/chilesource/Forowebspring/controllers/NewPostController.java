/*
 *  @author Jorge M.
 *  27-10-2021
 */

package com.chilesource.Forowebspring.controllers;

import com.chilesource.Forowebspring.model.Article;
import com.chilesource.Forowebspring.model.Post;
import com.chilesource.Forowebspring.service.CategoryService;
import com.chilesource.Forowebspring.service.PostService;
import com.chilesource.Forowebspring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@RequestMapping("/new-post")
public class NewPostController {

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String main(Model model) {
        model.addAttribute("post", new Post());
        return "new-post";
    }

//    @PostMapping
//    public String savePost(Post post, Model model) {
//        post.setDate(new Date());
//        post.setAuthor(userService.findById(1));
//        post.setCategory(categoryService.findById(1));
//        postService.save(post);
//        return "redirect:/post?id=" + post.getId();
//    }

    @PostMapping("/addpost")
    public String save(@ModelAttribute Post post, BindingResult result) {
        if (result.hasErrors()) {
            return "new-post";
        }
        post.setDate(new Date());
        post.setAuthor(userService.findById(1));
        post.setCategory(categoryService.findById(1));
        postService.save(post);
        return "redirect:/post?id=" + post.getId();
    }
}
