package com.chilesource.Forowebspring.repository;

import com.chilesource.Forowebspring.model.SuperCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * CrudRepository bean para SuperCategory
 *
 * @see com.chilesource.Forowebspring.service.SuperCategoryService
 */
@Repository
public interface SuperCategoryRepository extends CrudRepository<SuperCategory, Integer> {

}
