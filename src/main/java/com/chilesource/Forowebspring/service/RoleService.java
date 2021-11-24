package com.chilesource.Forowebspring.service;

import com.chilesource.Forowebspring.commons.GenericService;
import com.chilesource.Forowebspring.model.Role;
import com.chilesource.Forowebspring.repository.RoleRepository;
import org.springframework.stereotype.Service;

/**
 * Servicio correspondiente al modelo Role
 * **/

@Service
public class RoleService extends GenericService<Role, Integer> {

    /**
     * Instancia del servicio Role
     * @param repository recibe el repositorio correspondiente al modelo
     * **/
    public RoleService(RoleRepository repository) {
        super(repository);
    }
}
