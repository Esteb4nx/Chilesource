package com.chilesource.Forowebspring.controllers;

import com.chilesource.Forowebspring.model.Category;
import com.chilesource.Forowebspring.service.CategoryService;
import com.chilesource.Forowebspring.service.PostService;
import com.chilesource.Forowebspring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

/**
 * Clase encargada en mostrar las publicaciones organizadas por categoria
 * **/

@Controller
public class ForumController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private PostService postService;

    @Autowired
    private UserService userService;

    /**
     * Método que mapea la ruta de los post asociados dada una categoría
     *
     * @param id parámetro de la consulta
     * @param model UI model
     * @return vista forum.html
     *
     * <br><br>
     * Ya parece que nos alimentamos a base de tutoriales
     * @see <a href=https://spring.io/guides/gs/serving-web-content/>Servir contenido web con Spring MVC</a>
     */
    @GetMapping("/forum")
    public String forum(@RequestParam(value = "id") int id, Model model, Principal p) {
        Category category = categoryService.findById(id);

        if(category != null){
            model.addAttribute("category", category);
            model.addAttribute("posts", postService.findAllByCategoryId(id));

            // Header component query
            model.addAttribute("categories", categoryService.findAll());

            // Lastposts
            model.addAttribute("lastPosts", postService.findAllByCategoryIdOrderByDateDesc(id));

            if (p != null) {
                int userId = userService.findByUserName(p.getName()).getId();
                model.addAttribute("userId", userId);
            }

            return "forum";
        }else{
            // Header component query
            model.addAttribute("categories", categoryService.findAll());

            if (p != null) {
                int userId = userService.findByUserName(p.getName()).getId();
                model.addAttribute("userId", userId);
            }
            return "404";
        }


    }


}
