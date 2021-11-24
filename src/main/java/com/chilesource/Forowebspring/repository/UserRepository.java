package com.chilesource.Forowebspring.repository;

import com.chilesource.Forowebspring.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para operaciones CRUD de tipo <i>User</i>
 *
 * @see <a href="https://docs.spring.io/spring-data/commons/docs/2.6.0/api/org/springframework/data/repository/CrudRepository.html">CrudRepository</a>
 * @see User
 */
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    /**
     * Obtener <i>User</i>
     * @param name nombre de <i>User</i> buscado
     * @return <i>User</i> obtenido
     */
    User findByUserName(String name);
}
