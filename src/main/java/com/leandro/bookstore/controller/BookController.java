package com.leandro.bookstore.controller;

import com.leandro.bookstore.domain.Book;
import com.leandro.bookstore.dtos.BookDto;
import com.leandro.bookstore.service.BookService;
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
@RequestMapping(value = "/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Book> findById(@PathVariable Integer id) {
        Book bookFindById = bookService.findById(id);
        return ResponseEntity.ok().body(bookFindById);
    }

    @GetMapping
    public ResponseEntity<List<BookDto>> findAll(@RequestParam(value = "category", defaultValue = "0") Integer id_cat) {
        List<Book> books = bookService.findAll(id_cat);
        List<BookDto> bookDto = books.stream().map(obj -> new BookDto(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(bookDto);
    }

    @PostMapping
    public ResponseEntity<Book> post(@RequestParam(value = "category", defaultValue = "0") Integer id_cat,@Valid @RequestBody Book book) {
        Book bookPost = bookService.post(id_cat, book);
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/books/{id}").buildAndExpand(bookPost.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Book> update(@PathVariable Integer id,@Valid @RequestBody Book book) {
        Book bookUpdate = bookService.update(id, book);
        return ResponseEntity.ok().body(bookUpdate);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Book> updatePatch(@PathVariable Integer id,@Valid @RequestBody Book book) {
        Book bookUpdate = bookService.update(id, book);
        return ResponseEntity.ok().body(bookUpdate);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        bookService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
