package com.leandro.bookstore.controller;

import com.leandro.bookstore.domain.Category;
import com.leandro.bookstore.dtos.CategoryDto;
import com.leandro.bookstore.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;
@CrossOrigin("*")
@RestController
@RequestMapping(value = "/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryServiceController;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findById(@PathVariable Integer id) {
        Category categoryFindById = categoryServiceController.findById(id);
        return ResponseEntity.ok().body(categoryFindById);
    }

    @GetMapping
    public ResponseEntity<List<CategoryDto>> findAll() {
        List<Category> categoryList = categoryServiceController.findAll();
        List<CategoryDto> categoryDtoList = categoryList.stream().map(obj -> new CategoryDto(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(categoryDtoList);
    }

    @PostMapping
    public ResponseEntity<Category> post(@Valid @RequestBody Category categoryPost) {
        Category category = categoryServiceController.post(categoryPost);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(categoryPost.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CategoryDto> update(@Valid @PathVariable Integer id, @RequestBody CategoryDto categoryDto) {
        Category categoryUpdate = categoryServiceController.upadte(id, categoryDto);
        return ResponseEntity.ok().body(new CategoryDto(categoryUpdate));
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        categoryServiceController.delete(id);
        return ResponseEntity.noContent().build();
    }
}
