package com.chilesource.Forowebspring.controllers;

import com.chilesource.Forowebspring.commons.GenericService;
import com.chilesource.Forowebspring.model.Category;
import com.chilesource.Forowebspring.service.CategoryService;
import com.chilesource.Forowebspring.service.SuperCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    // Autowired servía aquí para no tener que asignarle un constructor al controlador
    // o eso entiendo: https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/annotation/Autowired.html
    // de cualquier forma los lo saqué por que la IDE me recomendó no agregarlo
    // luego lo agregué para no tener que hacer mas controller classes
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private SuperCategoryService superCategoryService;

    // Este constructor serviria en cada controlador, finalmente dejé la etiqueta Autowired en su lugar
    // ya que dos atributos me dejó de compilar por lo que probablemente haya que hacer más de un controlador
    // con esta práctica, por una parte se modulariza todo más y queda más claro lo dejo a tu criterio
//    public MainController(/* SuperCategoryService supCategoryService */ CategoryService service) {
//        this.categoryService = categoryService;
//        this.supCategoryService = supCategoryService;
//    }

    @RequestMapping("/")
    public String index(Model model) {
        // Consultar todos los registros
//        model.addAttribute("superCategories", supCategoryService.findAll());
        model.addAttribute("superCategories", superCategoryService.findAll());
        model.addAttribute("categories", categoryService.findAll());

//        // Consultar por id
//        model.addAttribute("category_1", categoryService.findById(1));
        return "index";
    }


    @RequestMapping("/favorites")
    public String favorites() {

        return "favorites";
    }

    @RequestMapping("/new-post")
    public String newPost() {

        return "new-post";
    }

    @GetMapping("/post")
    //@PathVariable("id") int id
    public String post() {

        return "post";
    }

//    @GetMapping("/forum")
//    //@PathVariable("id") int id
//    public String forum() {
//
//        return "forum";
//    }

    @RequestMapping("/register")
    public String register() {

        return "register";
    }

}
