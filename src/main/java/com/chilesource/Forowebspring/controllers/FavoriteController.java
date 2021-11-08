package com.chilesource.Forowebspring.controllers;

import com.chilesource.Forowebspring.service.FavoriteService;
import com.chilesource.Forowebspring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FavoriteController {

    @Autowired
    private FavoriteService favoriteService;

    @Autowired
    private UserService userService;

    @GetMapping("/favorites")
    public String favorites(@RequestParam(value = "id") int id, Model model){
        model.addAttribute("user", userService.findById(id));
        model.addAttribute("favorites", favoriteService.findAllByAuthorIdOrderByDateAsc(id));
        return "favorites";
    }

}
