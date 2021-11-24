package com.chilesource.Forowebspring.service;

import com.chilesource.Forowebspring.commons.GenericService;
import com.chilesource.Forowebspring.model.SuperCategory;
import com.chilesource.Forowebspring.repository.SuperCategoryRepository;
import org.springframework.stereotype.Service;

/**
 * Servicio correspondiente al modelo SuperCategory
 * **/

@Service
public class SuperCategoryService extends GenericService<SuperCategory, Integer> {
    // Constructor puede ser: SuperCategoryService(CrudRepository<SuperCategory, Integer> repository)
    // pero de esta forma sería mejor práctica
    // (eso no implica que SuperCategoryRepository no debiera existir, si se borra Spring no puede iniciar la app)
    // lo mismo para los otros services


    /**
     * Instancia del servicio SuperCategory
     * @param repository recibe el repositorio correspondiente al modelo
     * **/
    public SuperCategoryService(SuperCategoryRepository repository) {
        super(repository);
    }
}
