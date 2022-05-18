package com.leandro.bookstore.service;

import com.leandro.bookstore.domain.Book;
import com.leandro.bookstore.domain.Category;
import com.leandro.bookstore.repositories.BookRepository;
import com.leandro.bookstore.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private CategoryService categoryService;

    public Book findById(Integer id) {
        Optional<Book> byId = bookRepository.findById(id);
        return byId.orElseThrow(() -> new ObjectNotFoundException("Obeject Not Found, Id: " + id + ", Tipo: " + Book.class.getName()));
    }

    public List<Book> findAll(Integer id_cat) {
        categoryService.findById(id_cat);
        return bookRepository.findAllByCategory(id_cat);
    }

    public Book post(Integer id_cat, Book book) {
        book.setId(null);
        Category cat = categoryService.findById(id_cat);
        book.setCategory(cat);
        return bookRepository.save(book);
    }

    public Book update(Integer id, Book book) {
        Book newBook = findById(id);
        updateData(newBook, book);
        return bookRepository.save(newBook);
    }

    private void updateData(Book newBook, Book book) {
        newBook.setTitle(book.getTitle());
        newBook.setAuthor_name(book.getAuthor_name());
        newBook.setText(book.getText());
    }

    public void delete(Integer id) {
        final Book book = findById(id);
        bookRepository.delete(book);
    }
}