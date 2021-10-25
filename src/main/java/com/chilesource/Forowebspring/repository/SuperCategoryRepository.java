/*
 *  @author Jorge M.
 *  24-10-2021
 */

package com.chilesource.Forowebspring.repository;

import com.chilesource.Forowebspring.model.SuperCategory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * CrudRepository bean para el uso de su Service respectivo en {@link com.chilesource.Forowebspring.service}
 */
@Repository
public interface SuperCategoryRepository extends CrudRepository<SuperCategory, Integer> {

}
