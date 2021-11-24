package com.chilesource.Forowebspring.service;

import com.chilesource.Forowebspring.commons.GenericService;
import com.chilesource.Forowebspring.model.Category;
import com.chilesource.Forowebspring.repository.CategoryRepository;
import org.springframework.stereotype.Service;
/**
 * Servicio correspondiente al modelo Category
 * **/


@Service
public class CategoryService extends GenericService<Category, Integer> {

    /**
     * Instancia del servicio Category
     * @param repository recibe el repositorio correspondiente al modelo
     * **/

    public CategoryService(CategoryRepository repository) {
        super(repository);
    }
}
