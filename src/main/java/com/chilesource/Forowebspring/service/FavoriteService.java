package com.chilesource.Forowebspring.service;

import com.chilesource.Forowebspring.commons.GenericService;
import com.chilesource.Forowebspring.model.Favorite;
import com.chilesource.Forowebspring.model.Post;
import com.chilesource.Forowebspring.repository.FavoriteRepository;
import com.chilesource.Forowebspring.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class FavoriteService extends GenericService<Favorite, Integer> {
    public FavoriteService(FavoriteRepository repository) {
        super(repository);
    }

    public Iterable<Favorite> findAllByAuthorIdOrderByDateAsc(int userId){
        return ((FavoriteRepository) repository).findAllByUserIdOrderByDateAsc(userId);
    }
}
