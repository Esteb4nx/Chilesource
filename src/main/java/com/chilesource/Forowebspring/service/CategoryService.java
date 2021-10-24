/*
 *  @author Jorge M.
 *  23-10-2021
 */

package com.chilesource.Forowebspring.service;

import com.chilesource.Forowebspring.model.Category;
import com.chilesource.Forowebspring.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    // Obtener todos el registro de libros utilizando el método
    // findAll() de CrudRepository
    public List<Category> getAllCategories() {
        List<Category> categories = new ArrayList<Category>();
        categoryRepository.findAll().forEach(categories::add);
        return categories;
    }

    public Category getCategoryById(int id) {
        return categoryRepository.findById(id).get();
    }

    public void saveOrUpdate(Category category) {
        categoryRepository.save(category);
    }

    public void delete(int id) {
        categoryRepository.deleteById(id);
    }


}
