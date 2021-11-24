package com.chilesource.Forowebspring.service;

import com.chilesource.Forowebspring.commons.GenericService;
import com.chilesource.Forowebspring.model.Commentary;
import com.chilesource.Forowebspring.model.Favorite;
import com.chilesource.Forowebspring.repository.CommentaryRepository;
import com.chilesource.Forowebspring.repository.FavoriteRepository;
import org.springframework.stereotype.Service;

/**
 * Servicio correspondiente al modelo Commentary
 * **/

@Service
public class CommentaryService extends GenericService<Commentary, Integer> {

    /**
     * Instancia del servicio Commentary
     * @param repository recibe el repositorio correspondiente al modelo
     * **/
    public CommentaryService(CommentaryRepository repository) {
        super(repository);
    }

    /**
     * Metodo Buscar Comentarios por Post ID ordenados por fecha
     * El metodo recibe el resultado de la operación realizada por el repositorio
     * @param postId ID del post donde se encuentran los comentarios
     * @return Todos los comentarios asociados al post
     * **/

    public Iterable<Commentary> findAllByPostIdOrderByDateAsc(int postId){
        return ((CommentaryRepository) repository).findAllByPostIdOrderByDateAsc(postId);
    }
}
