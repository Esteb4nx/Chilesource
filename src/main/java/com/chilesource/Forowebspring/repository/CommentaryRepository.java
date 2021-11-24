package com.chilesource.Forowebspring.repository;

import com.chilesource.Forowebspring.model.Commentary;
import com.chilesource.Forowebspring.model.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para operaciones CRUD de tipo <i>Commentary</i>
 *
 * @see <a href="https://docs.spring.io/spring-data/commons/docs/2.6.0/api/org/springframework/data/repository/CrudRepository.html">CrudRepository</a>
 * @see Commentary
 */
@Repository
public interface CommentaryRepository extends CrudRepository<Commentary, Integer> {
    /**
     * Obtener todos los <i>Commentary</i> de <i>Post</i> ordenados por fecha ascendente
     * @param postId id de <i>Post</i> buscado
     * @return Iterable con <i>Commentary</i> obtenidos
     */
    Iterable<Commentary> findAllByPostIdOrderByDateAsc(int postId);
}
