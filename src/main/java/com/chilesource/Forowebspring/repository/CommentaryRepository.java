package com.chilesource.Forowebspring.repository;

import com.chilesource.Forowebspring.model.Commentary;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentaryRepository extends CrudRepository<Commentary, Integer> {
}
