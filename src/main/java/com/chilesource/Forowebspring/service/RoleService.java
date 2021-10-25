/*
 *  @author Jorge M.
 *  25-10-2021
 */

package com.chilesource.Forowebspring.service;

import com.chilesource.Forowebspring.commons.GenericService;
import com.chilesource.Forowebspring.model.Role;
import com.chilesource.Forowebspring.repository.RoleRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService extends GenericService<Role, Integer> {
    public RoleService(RoleRepository repository) {
        super(repository);
    }
}