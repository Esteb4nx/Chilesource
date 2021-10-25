/*
 *  @author Jorge M.
 *  25-10-2021
 */

package com.chilesource.Forowebspring.repository;

import com.chilesource.Forowebspring.model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {

}
