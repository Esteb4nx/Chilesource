package com.chilesource.Forowebspring.service;

import com.chilesource.Forowebspring.commons.GenericService;
import com.chilesource.Forowebspring.model.Post;
import com.chilesource.Forowebspring.repository.PostRepository;
import org.springframework.stereotype.Service;
/**
 * Servicio correspondiente al modelo Post
 * **/


@Service
public class PostService extends GenericService<Post, Integer> {

    /**
     * Instancia del servicio Post
     * @param repository recibe el repositorio correspondiente al modelo
     * **/
    public PostService(PostRepository repository) {
        super(repository);
    }


    /**
     * Metodo buscar todos los Post por Category ID
     * @param categoryId ID de la category asociada
     * @return resultado de la operación realizada por el repositorio
     * **/
    public Iterable<Post> findAllByCategoryId(int categoryId) throws IllegalArgumentException {
        if (categoryId > 0) {
            return ((PostRepository) repository).findAllByCategoryId(categoryId);
        } else {
            throw new IllegalArgumentException("Id categoría debe ser mayor que 0");
        }
    }

    /**
     * Metodo buscar todos los port por categoria ordenados por fecha.
     * @param categoryId ID de la category asociada
     * @return resltado de la operación realizada por el repositorio
     * **/

    public Iterable<Post> findAllByCategoryIdOrderByDateDesc(int categoryId) throws IllegalArgumentException {
        if (categoryId > 0) {
            return ((PostRepository) repository).findAllByCategoryIdOrderByDateDesc(categoryId);
        } else {
            throw new IllegalArgumentException("Id categoría debe ser mayor que 0");
        }
    }

    /**
     * Metodo buscar todos los port según su autor ordenados por fecha.
     * @param userId ID del usuario autor de los post
     * @return resltado de la operación realizada por el repositorio
     * **/

    public Iterable<Post> findAllByAuthorIdOrderByDateAsc(int userId) throws IllegalArgumentException {
        if (userId > 0) {
            return ((PostRepository) repository).findAllByAuthorIdOrderByDateAsc(userId);
        } else {
            throw new IllegalArgumentException("Id usuario debe ser mayor que 0");
        }
    }

}
