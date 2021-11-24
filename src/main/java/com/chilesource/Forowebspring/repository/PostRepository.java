package com.chilesource.Forowebspring.repository;

import com.chilesource.Forowebspring.model.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para operaciones CRUD de tipo <i>Post</i>
 *
 * @see <a href="https://docs.spring.io/spring-data/commons/docs/2.6.0/api/org/springframework/data/repository/CrudRepository.html">CrudRepository</a>
 * @see Post
 */
@Repository
public interface PostRepository extends CrudRepository<Post, Integer> {
    /**
     * Obtener todos los <i>Post</i> de <i>Category</i>
     * @param categoryId id de <i>Category</i> buscado
     * @return Iterable con <i>Post</i> obtenidos
     */
    Iterable<Post> findAllByCategoryId(int categoryId);

    /**
     * Obtener todos los <i>Post</i> de <i>Category</i> ordenados por fecha descendente
     * @param categoryId id de <i>Category</i> buscado
     * @return Iterable con <i>Post</i> obtenidos
     */
    Iterable<Post> findAllByCategoryIdOrderByDateDesc(int categoryId);

    /**
     * Obtener todos los <i>Post</i> de <i>User</i> ordenados por fecha ascendente
     * @param userId id de <i>User</i> buscado
     * @return Iterable con <i>Post</i> obtenidos
     */
    Iterable<Post> findAllByAuthorIdOrderByDateAsc(int userId);
}