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

import java.security.Principal;
import java.util.Date;

/*
* Clase encargada de las vistas de las publicaciones y la gestion de comentarios dentro de estas
* */


@Controller
@RequestMapping("/post")
public class PostController {

    /**
     *Instanciación de los servicios para los modelos necesarios en el controlador.
     * **/

    @Autowired
    private UserService userService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private PostService postService;

    @Autowired
    private CommentaryService commentaryService;


    /**
     * Ruta de cada publicación
     * El metodo recibe el id del post por URL y trae los datos desde la base de datos
     * @param id del post
     * @return Vista post
     * **/

    @GetMapping
    public String main(@RequestParam(value = "id") int id, Model model, Principal p) {
        Post post = postService.findById(id);
        // Se necesita la var fuera para el caso del user guest
        boolean isAuthor = false;

        if (post != null) {
            if (p != null) {
                isAuthor = p.getName().equals(post.getAuthor().getUserName());
                // Logged user info
                int userId = userService.findByUserName(p.getName()).getId();
                String userPP = userService.findById(userId).getProfilePicture();
                model.addAttribute("userId", userId);
                model.addAttribute("userPP", userPP);
            }

            model.addAttribute("post", post);
            model.addAttribute("isAuthor", isAuthor);

            // Header component query
            model.addAttribute("categories", categoryService.findAll());

            //Comentarios
            model.addAttribute("commentaries", commentaryService.findAllByPostIdOrderByDateAsc(id));

            return "post";
        }else{

            if (p != null) {
                // Logged user info
                int userId = userService.findByUserName(p.getName()).getId();
                model.addAttribute("userId", userId);
            }

            model.addAttribute("categories", categoryService.findAll());
            return "404";
        }

    }

    /**
     * Ruta para editar publicaciones
     * El metodo recibe el id del post por URL y trae los datos en un formulario desde la DB
     * @param id del post
     * @return Vista formulario de edición
     * **/

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

    /**
     * Ruta que ejecuta el edit en la base de datos
     * El metodo guarda el objeto post modificado en la base de datos
     * @param post Objeto post con los nuevos datos
     * **/

    @PostMapping("/edit-post")
    public String editPostSubmit(@ModelAttribute Post post){
        postService.save(post);

        return "redirect:/";
    }

    /**
     * Ruta para eliminar publicación
     * Recibe id del post por parametro y la elimina de la DB usando els ervicio
     *
     * @param id del post
     * **/

    @RequestMapping("/delete")
    public String deletePost(@RequestParam(value = "id") int id, Model model) {
        postService.deleteById(id);
        return "redirect:/";
    }

    /**
     * Ruta que guarda los comentarios
     * El metodo recibe un objeto Commentary, le inserta la fecha y los guarda en la base de datos usando el servicio
     *
     * @param commentary Objeto Commentary
     * **/

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
