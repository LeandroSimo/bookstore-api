package com.leandro.bookstore.service;

import com.leandro.bookstore.domain.Category;
import com.leandro.bookstore.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepositoryService;

    public Category findById(Integer id) {
        Optional<Category> byId = categoryRepositoryService.findById(id);
        return byId.orElse(null);
    }
}
