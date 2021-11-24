package com.chilesource.Forowebspring.controllers;

import com.chilesource.Forowebspring.model.User;
import com.chilesource.Forowebspring.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

/*
* Clase principal de rutas, encargada de mostrar el Index de la aplicación y la creación de usuarios nuevos en el sitio.
* */

@Controller
public class MainController {

    /**
     *Instanciación de los servicios para los modelos necesarios en el controlador.
     * **/

    @Autowired
    private UserService userService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private SuperCategoryService superCategoryService;

    /**
     * Ruta principal de la aplicación INDEX
     * Metodo que renderiza el index.
     * @return index.html
     * **/

    @RequestMapping("/")
    public String index(Model model, Principal p) {
        // Consultar todos los registros de categorias y supercategorias
        model.addAttribute("superCategories", superCategoryService.findAll());
        model.addAttribute("categories", categoryService.findAll());

        if (p != null) {
            // Logged user info
            int userId = userService.findByUserName(p.getName()).getId();
            model.addAttribute("userId", userId);
        }

        return "index";
    }

    /**
     * Ruta del formulario de registro
     * Genera un objeto usuario y setea sus datos apartir del formulario, luego se envía por POST a "/new-user"
     * @return Vista de registro
     * **/

    @RequestMapping("/register")
    public String register(Model model, Principal p) {
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("user", new User());

        // FIXME: remplazar por redirect a otra página al ser usuario logeado
        if (p != null) {
            // Logged user info
            int userId = userService.findByUserName(p.getName()).getId();
            model.addAttribute("userId", userId);
        }

        return "register";
    }

    /**
     * Ruta que registra los usuarios en la base de datos.
     * El metodo recibe un objeto User con los datos y mediante el servicio crea el usuario en la DB
     *
     * @param user objeto usuario creado con los datos del formulario.
     * **/

    @PostMapping("/new-user")
    public String newUser(@ModelAttribute User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setProfilePicture("https://avatars.dicebear.com/api/initials/"+user.getUserName()+".svg?&backgroundColors[]=pink&backgroundColors[]=purple&backgroundColors[]=red&backgroundColors[]=teal&backgroundColors[]=yellow&backgroundColors[]=lime&backgroundColors[]=orange&backgroundColors[]=lightGreen&backgroundColors[]=indigo&backgroundColors[]=grey&backgroundColors[]=green&backgroundColors[]=deepPurple&backgroundColors[]=deepOrange&backgroundColors[]=brown&backgroundColors[]=amber&fontSize=56");
        user.setPassword(encoder.encode(user.getPassword()));
        userService.save(user);
        return "redirect:/";
    }

}
