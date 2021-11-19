/*
 *  @author Jorge M.
 *  @author Esteban E.
 *  24-10-2021
 */

package com.chilesource.Forowebspring.service;

import com.chilesource.Forowebspring.commons.GenericService;
import com.chilesource.Forowebspring.model.SuperCategory;
import com.chilesource.Forowebspring.repository.SuperCategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class SuperCategoryService extends GenericService<SuperCategory, Integer> {
    // Constructor puede ser: SuperCategoryService(CrudRepository<SuperCategory, Integer> repository)
    // pero de esta forma sería mejor práctica
    // (eso no implica que SuperCategoryRepository no debiera existir, si se borra Spring no puede iniciar la app)
    // lo mismo para los otros services
    public SuperCategoryService(SuperCategoryRepository repository) {
        super(repository);
    }
}
