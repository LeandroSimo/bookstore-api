package com.leandro.bookstore.service;

import com.leandro.bookstore.domain.Category;
import com.leandro.bookstore.dtos.CategoryDto;
import com.leandro.bookstore.repositories.CategoryRepository;
import com.leandro.bookstore.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepositoryService;

    public Category findById(Integer id) {
        Optional<Category> byId = categoryRepositoryService.findById(id);
        return byId.orElseThrow(() -> new ObjectNotFoundException(
                "Object Not Found, Id: " + id + ", Tipo:" + Category.class.getName()));
    }

    public List<Category> findAll() {
        return categoryRepositoryService.findAll();
    }

    public Category post(Category categoryPost) {
        categoryPost.setId(null);
        Category categorySave = categoryRepositoryService.save(categoryPost);
        return categorySave;
    }

    public Category upadte(Integer id, CategoryDto categoryDto) {
        Category categoryUpdate = findById(id);
        categoryUpdate.setName(categoryDto.getName());
        categoryUpdate.setDescription(categoryDto.getDescription());
        return categoryRepositoryService.save(categoryUpdate);
    }

    public void delete(Integer id) {
        findById(id);
        try {
            categoryRepositoryService.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new com.leandro.bookstore.service.exceptions.DataIntegrityViolationException
                    ("Category cannot be deleted! Has associated books");
        }
    }
}

