package com.chilesource.Forowebspring.controllers;

import com.chilesource.Forowebspring.model.Favorite;
import com.chilesource.Forowebspring.service.CategoryService;
import com.chilesource.Forowebspring.service.FavoriteService;
import com.chilesource.Forowebspring.service.PostService;
import com.chilesource.Forowebspring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.Date;

/* *
 * Clase encargada de enrutar, mostrar, borrar y crear favoritos
 * */

@Controller
public class FavoriteController {

    /**
     *Instanciación de los servicios para los modelos necesarios en el controlador.
     * **/

    @Autowired
    private FavoriteService favoriteService;

    @Autowired
    private UserService userService;

    @Autowired
    private PostService postService;

    @Autowired
    private CategoryService categoryService;

    /**
     * Ruta favoritos.
     * Recibe id del usuario por parametro para buscarlo en la base de datos.
     * @param id del usuario.
     * @return Vista de favoritos.
     * **/

    @GetMapping("/favorites")
    public String favorites(@RequestParam(value = "user_id") int id, Model model, Principal p){
        model.addAttribute("user", userService.findById(id));
        model.addAttribute("favorites", favoriteService.findAllByAuthorIdOrderByDateAsc(id));
        model.addAttribute("categories", categoryService.findAll()); // component header query
        boolean isAuthor = false;

        if (p != null) {
            // FIXME refactor: extraer variable
            isAuthor = p.getName().equals(userService.findById(id).getUserName());
            int userId = userService.findByUserName(p.getName()).getId();
            model.addAttribute("userId", userId);
            model.addAttribute("isAuthor", isAuthor);
        }

        return "favorites";
    }

    /**
     * Metodo para añadir un favorito.
     * Se recibe los datos de la publicación mediante GET en formato objeto, se genera la fecha de creación del fav y
     * añade al objeto Favorite.
     * @param id id del post a añadirse a favoritos.
     * @param favorite objeto favorito creado.
     * **/

    @GetMapping("/favorite/add")
    public String addFavorite(@RequestParam(value = "post_id") int id,
                              @ModelAttribute Favorite favorite,
                              Principal p) {
        Date date = new Date();
        java.sql.Timestamp sqlTimeStamp = new java.sql.Timestamp(date.getTime());
        favorite.setDate(sqlTimeStamp);

        if (p != null) {
            favorite.setPost(postService.findById(id));
            favorite.setUser(userService.findByUserName(p.getName()));
        }

        favoriteService.save(favorite);
        return "redirect:/favorites?user_id=" + favorite.getUser().getId();
    }

    /**
     * Ruta para eliminar favoritos.
     * Se pasa el id del favorito por parametro y se borra de la base de datos.
     * @param id id del favorito.
     * **/

    @GetMapping("/favorite/delete")
    public String deleteFavorite(@RequestParam(value = "fav_id") int id){
        int user_id = favoriteService.findById(id).getUser().getId();

        favoriteService.deleteById(id);

        return "redirect:/favorites?user_id=" + user_id;
    }
}
