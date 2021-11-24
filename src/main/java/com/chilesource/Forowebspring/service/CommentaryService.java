package com.chilesource.Forowebspring.service;

import com.chilesource.Forowebspring.commons.GenericService;
import com.chilesource.Forowebspring.model.Commentary;
import com.chilesource.Forowebspring.model.Favorite;
import com.chilesource.Forowebspring.repository.CommentaryRepository;
import com.chilesource.Forowebspring.repository.FavoriteRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentaryService extends GenericService<Commentary, Integer> {
    public CommentaryService(CommentaryRepository repository) {
        super(repository);
    }

    public Iterable<Commentary> findAllByPostIdOrderByDateAsc(int postId){
        return ((CommentaryRepository) repository).findAllByPostIdOrderByDateAsc(postId);
    }
}
