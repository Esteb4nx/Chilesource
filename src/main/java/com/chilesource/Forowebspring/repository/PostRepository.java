package com.chilesource.Forowebspring.repository;

import com.chilesource.Forowebspring.model.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends CrudRepository<Post, Integer> {
    Iterable<Post> findAllByCategoryId(int categoryId);

    Iterable<Post> findAllByCategoryIdOrderByDateAsc(int categoryId);
}