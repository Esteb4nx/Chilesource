/*
 *  @author Jorge M.
 *  27-10-2021
 */

package com.chilesource.Forowebspring.controllers;

import com.chilesource.Forowebspring.model.Post;
import com.chilesource.Forowebspring.service.CategoryService;
import com.chilesource.Forowebspring.service.PostService;
import com.chilesource.Forowebspring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
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
    public String main(Model model, Principal p) {
        // FIXME buena práctica: nombrar atributo como newPost
        model.addAttribute("post", new Post());
        model.addAttribute("categories", categoryService.findAll());

        if (p != null) {
            int userId = userService.findByUserName(p.getName()).getId();
            model.addAttribute("userId", userId);
        }

        return "new-post";
    }

    @PostMapping
    public String save(@ModelAttribute Post post, Principal p) {
        Date date = new Date();
        java.sql.Timestamp sqlTimeStamp = new java.sql.Timestamp(date.getTime());
        post.setDate(sqlTimeStamp);
        int randomUserId = 1 + (int) (Math.random() * 3);
        if (p != null) {
            int userId = userService.findByUserName(p.getName()).getId();
            post.setAuthor(userService.findById(userId));
        }
        postService.save(post);
        return "redirect:/post?id=" + post.getId();
    }
}
