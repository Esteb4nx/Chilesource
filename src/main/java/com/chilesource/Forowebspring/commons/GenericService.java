/*
 *  @author Jorge M.
 *  24-10-2021
 */

package com.chilesource.Forowebspring.commons;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Servicio genérico para operaciones CRUD
 * @param <T> Tipo del servicio a ser utilizado (Una entidad)
 * @param <ID> Tipo de identificador
 *
 * @version 1.0
 */
public class GenericService<T, ID> {
    private CrudRepository<T, ID> repository;

    public GenericService(CrudRepository<T, ID> repository) {
        this.repository = repository;
    }

    public Iterable<T> findAll() {
        return repository.findAll();
    }

    public T findById(ID id) {
        Optional<T> category = repository.findById(id);
        return category.orElse(null);
    }

    public T save(T category) {
        return repository.save(category);
    }

    public Iterable<T> saveAll(Iterable<T> objects) {
        return repository.saveAll(objects);
    }

    boolean existsById(ID id) {
        return repository.existsById(id);
    }

    Iterable<T> findAllById(Iterable<ID> ids) {
        return repository.findAllById(ids);
    }

    long count() {
        return repository.count();
    }

    void deleteById(ID id) {
        repository.deleteById(id);
    }

    void delete(T entity) {
        repository.delete(entity);
    }

    void deleteAllById(Iterable<? extends ID> ids) {
        repository.deleteAllById(ids);
    }

    void deleteAll(Iterable<? extends T> entities) {
        repository.deleteAll(entities);
    }

    void deleteAll() {
        repository.deleteAll();
    }

}
