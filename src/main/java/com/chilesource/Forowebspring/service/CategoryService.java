package com.chilesource.Forowebspring.service;

import com.chilesource.Forowebspring.commons.GenericService;
import com.chilesource.Forowebspring.model.Category;
import com.chilesource.Forowebspring.repository.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryService extends GenericService<Category, Integer> {
    public CategoryService(CategoryRepository repository) {
        super(repository);
    }
}
