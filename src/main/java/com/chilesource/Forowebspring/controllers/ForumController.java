/*
 *  @author Jorge M.
 *  25-10-2021
 */

package com.chilesource.Forowebspring.controllers;

import com.chilesource.Forowebspring.model.Category;
import com.chilesource.Forowebspring.model.Post;
import com.chilesource.Forowebspring.service.CategoryService;
import com.chilesource.Forowebspring.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ForumController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private PostService postService;

    /**
     * Método que mapea la ruta de los post asociados dada una categoría
     *
     * @param id parámetro de la consulta
     * @param model UI model
     * @return vista forum.html
     *
     * Ya parece que nos alimentamos a base de tutoriales
     * @see <a href=https://spring.io/guides/gs/serving-web-content/>Servir contenido web con Spring MVC</a>
     */
    @GetMapping("/forum")
    public String forum(@RequestParam(value = "id") int id, Model model) {
        model.addAttribute("category", categoryService.findById(id));
        //Iterable<Post> posts = postService.findAll();
        model.addAttribute("posts", postService.findAllByCategoryId(id));

        return "forum";
    }


}
