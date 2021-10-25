/*
 *  @author Jorge M.
 *  24-10-2021
 */

package com.chilesource.Forowebspring.commons;

import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Servicio genérico para operaciones CRUD
 * @param <T> Tipo del servicio a ser utilizado (Una entidad)
 * @param <ID> Tipo de identificador
 *
 * @version 1.0
 */
public class GenericService<T, ID> {
    private final CrudRepository<T, Integer> repository;

    public GenericService(CrudRepository<T, Integer> repository) {
        this.repository = repository;
    }

    // Obtener todos los registros utilizando el método
    // findAll() de CrudRepository
    public List<T> findAll() {
        List<T> list = new ArrayList<>();
        Iterable<T> objects = repository.findAll();
        objects.forEach(list::add);
        return list;
    }

    public Optional<T> find(int id) {
        return repository.findById(id);
    }

    public T create(T obj) {
        return repository.save(obj);
    }

    public T update(T newObj) {
        return repository.save(newObj);
    }

    public void delete(int id) {
        repository.deleteById(id);
    }

}
