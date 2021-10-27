/*
 *  @author Jorge M.
 *  25-10-2021
 */

package com.chilesource.Forowebspring.service;

import com.chilesource.Forowebspring.commons.GenericService;
import com.chilesource.Forowebspring.model.Post;
import com.chilesource.Forowebspring.repository.PostRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

@Service
public class PostService extends GenericService<Post, Integer> {
    public PostService(PostRepository repository) {
        super(repository);
    }

    public Iterable<Post> findAllByCategoryId(int categoryId) {
        return ((PostRepository) repository).findAllByCategoryId(categoryId);
    }

    //@Query("SELECT '*' FROM post ORDER BY post_date ASC")
    public Iterable<Post> findAllByCategoryIdOrderByDateAsc(int categoryId){
        return ((PostRepository) repository).findAllByCategoryIdOrderByDateAsc(categoryId);
    }
}
