package com.chilesource.Forowebspring.repository;

import com.chilesource.Forowebspring.model.Favorite;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para operaciones CRUD de tipo <i>Favorite</i>
 *
 * @see <a href="https://docs.spring.io/spring-data/commons/docs/2.6.0/api/org/springframework/data/repository/CrudRepository.html">CrudRepository</a>
 * @see Favorite
 */
@Repository
public interface FavoriteRepository extends CrudRepository<Favorite, Integer> {
    /**
     * Obtener todos los <i>Favorite</i> de <i>User</i> ordenados por fecha ascendente
     * @param userId id de <i>User</i> buscado
     * @return Iterable con <i>Favorite</i> obtenidos
     */
    Iterable<Favorite> findAllByUserIdOrderByDateAsc(int userId);
}
