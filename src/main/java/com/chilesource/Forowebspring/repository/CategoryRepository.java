/*
 *  @author Jorge M.
 *  23-10-2021
 */

package com.chilesource.Forowebspring.repository;

import com.chilesource.Forowebspring.model.Category;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * CrudRepository bean para el uso de su Service respectivo en {@link com.chilesource.Forowebspring.service}
 */
@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {


}
