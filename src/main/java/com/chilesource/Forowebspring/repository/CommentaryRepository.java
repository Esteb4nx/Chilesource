package com.chilesource.Forowebspring.repository;

import com.chilesource.Forowebspring.model.Commentary;
import com.chilesource.Forowebspring.model.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentaryRepository extends CrudRepository<Commentary, Integer> {
    Iterable<Commentary> findAllByPostIdOrderByDateAsc(int postId);
}
