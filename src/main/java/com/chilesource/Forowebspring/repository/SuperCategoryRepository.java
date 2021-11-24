package com.chilesource.Forowebspring.repository;

import com.chilesource.Forowebspring.model.SuperCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para operaciones CRUD de tipo <i>SuperCategory</i>
 *
 * @see <a href="https://docs.spring.io/spring-data/commons/docs/2.6.0/api/org/springframework/data/repository/CrudRepository.html">CrudRepository</a>
 * @see SuperCategory
 */
@Repository
public interface SuperCategoryRepository extends CrudRepository<SuperCategory, Integer> {

}
