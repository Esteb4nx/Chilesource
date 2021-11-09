package com.chilesource.Forowebspring.controllers;

import com.chilesource.Forowebspring.model.Favorite;
import com.chilesource.Forowebspring.model.Post;
import com.chilesource.Forowebspring.service.FavoriteService;
import com.chilesource.Forowebspring.service.PostService;
import com.chilesource.Forowebspring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@Controller
public class FavoriteController {

    @Autowired
    private FavoriteService favoriteService;

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    @GetMapping("/favorites")
    public String favorites(@RequestParam(value = "user_id") int id, Model model){
        model.addAttribute("user", userService.findById(id));
        model.addAttribute("favorites", favoriteService.findAllByAuthorIdOrderByDateAsc(id));
        return "favorites";
    }

    @GetMapping("/favorite/add")
    public String addFavorite(@RequestParam(value = "post_id") int id, @ModelAttribute Favorite favorite){
        Date date = new Date();
        java.sql.Timestamp sqlTimeStamp = new java.sql.Timestamp(date.getTime());
        favorite.setDate(sqlTimeStamp);

        favorite.setPost(postService.findById(id));
        favorite.setUser(userService.findById(1));

        favoriteService.save(favorite);
        return "redirect:/favorites?user_id=" + favorite.getUser().getId();
    }
}
