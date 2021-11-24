package com.chilesource.Forowebspring.repository;

import com.chilesource.Forowebspring.model.Role;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para operaciones CRUD de tipo <i>Role</i>
 *
 * @see <a href="https://docs.spring.io/spring-data/commons/docs/2.6.0/api/org/springframework/data/repository/CrudRepository.html">CrudRepository</a>
 * @see Role
 */
@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {
    /**
     * Obtener <i>Role</i>
     * @param role nombre de <i>Role</i> buscado
     * @return <i>Role</i> obtenido
     */
    Role findByRoleName(String role);
}
