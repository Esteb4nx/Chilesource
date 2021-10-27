package com.chilesource.Forowebspring.repository;

import com.chilesource.Forowebspring.model.Favorite;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavoriteRepository extends CrudRepository<Favorite, Integer> {

}
