package com.chilesource.Forowebspring.repository;

import com.chilesource.Forowebspring.model.Category;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para operaciones CRUD de tipo <i>Category</i>
 *
 * @see <a href="https://docs.spring.io/spring-data/commons/docs/2.6.0/api/org/springframework/data/repository/CrudRepository.html">CrudRepository</a>
 * @see Category
 */
@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {

}
