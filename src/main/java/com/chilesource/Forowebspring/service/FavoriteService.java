package com.chilesource.Forowebspring.service;

import com.chilesource.Forowebspring.commons.GenericService;
import com.chilesource.Forowebspring.model.Favorite;
import com.chilesource.Forowebspring.model.Post;
import com.chilesource.Forowebspring.repository.FavoriteRepository;
import com.chilesource.Forowebspring.repository.PostRepository;
import org.springframework.stereotype.Service;

/**
 * Servicio correspondiente al modelo Favorite
 * **/

@Service
public class FavoriteService extends GenericService<Favorite, Integer> {

    /**
     * Instancia del servicio Favorite
     * @param repository recibe el repositorio correspondiente al modelo
     * **/
    public FavoriteService(FavoriteRepository repository) {
        super(repository);
    }


    /**
     * Metodo buscar todos lso favoritos por User ID ordenados por fecha
     * @param userId ID del usuario al que estan asociados los favoritos
     * @return resultado de la operación realizada por el repositorio
     * **/
    public Iterable<Favorite> findAllByAuthorIdOrderByDateAsc(int userId){
        return ((FavoriteRepository) repository).findAllByUserIdOrderByDateAsc(userId);
    }
}
