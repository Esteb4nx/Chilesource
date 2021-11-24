package com.chilesource.Forowebspring.controllers;

import com.chilesource.Forowebspring.model.User;
import com.chilesource.Forowebspring.service.CategoryService;
import com.chilesource.Forowebspring.service.PostService;
import com.chilesource.Forowebspring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

/**
 * Clase encargada de los perfiles de usuario y la edición de estos
 * **/


// FIXME: Evaluar cambiar nombre de la clase a ProfileController por las rutas que mapea
@Controller
@RequestMapping("/profile")
public class UserController {

    /**
     *Instanciación de los servicios para los modelos necesarios en el controlador.
     * **/

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;


    /**
     * Ruta del perfil de usuario
     * El metodo recibe el id del usuario y trae sus datos desde la DB
     *
     * @param id del usuario
     * @return Vista de perfil
     * **/

    @GetMapping
    public String profile(@RequestParam(value = "id") int id, Model model, Principal p){

        User user = userService.findById(id);
        boolean isAuthor = false;



        if(user != null){

            if (p != null) {
                isAuthor = p.getName().equals(user.getUserName());

                int userId = userService.findByUserName(p.getName()).getId();
                model.addAttribute("userId", userId);
            }

            model.addAttribute("isAuthor", isAuthor);
            model.addAttribute("user",user);
            model.addAttribute("posts", postService.findAllByAuthorIdOrderByDateAsc(id));
            model.addAttribute("categories", categoryService.findAll());

            return "profile";
        }else{
            model.addAttribute("categories", categoryService.findAll());

            if (p != null) {
                // Logged user info
                int userId = userService.findByUserName(p.getName()).getId();
                model.addAttribute("userId", userId);
            }
            return "404";
        }

    }

    /**
     * Ruta formulario de edición perfil
     * El metodo recibe el id del usuario y treae sus datos en un formulario
     * @param id del usuario
     * @return Vista editar perfil
     * **/

    @GetMapping("/edit")
    public String editProfile(@RequestParam(value = "user_id") int id, Model model, Principal p){

        // Header component query
        model.addAttribute("categories", categoryService.findAll());

        model.addAttribute("user", userService.findById(id));


        if (p != null) {
            // Logged user info
            int userId = userService.findByUserName(p.getName()).getId();
            model.addAttribute("userId", userId);
        }

        return "edit-profile";
    }

    // FIXME seguridad: si el usuario edita el hidden input que se encuentra en el html
    // puede lograr duplicar o tener acceso a acciones no esperadas sobre la aplicación, ocurre también con edit/post
    // se ven expuestos atributos que no queremos que se vean cómo password o id p.ej.

    /**
     * Metodo que procesa la edición del perfil
     * El metodo recibe el objeto User con los datos modificados y lo guarda y aplica los cambios en la DB
     * @param user Objeto User modificado
     * **/

    @PostMapping("/edit/submit")
    public String editProfileSubmit(@ModelAttribute User user) {
        userService.save(user);
        return "redirect:/profile?id=" + user.getId();
    }
}
