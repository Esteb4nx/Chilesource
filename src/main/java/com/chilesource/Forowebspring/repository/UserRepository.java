/*
 *  @author Jorge M.
 *  25-10-2021
 */

package com.chilesource.Forowebspring.repository;

import com.chilesource.Forowebspring.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUserName(String name);
}
