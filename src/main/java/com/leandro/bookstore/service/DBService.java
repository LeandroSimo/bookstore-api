package com.leandro.bookstore.service;

import com.leandro.bookstore.domain.Book;
import com.leandro.bookstore.domain.Category;
import com.leandro.bookstore.repository.BookRepository;
import com.leandro.bookstore.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private BookRepository bookRepository;

    public void instanceDB() {
        Category category1 = new Category(null, "Informática", "Livros de TI");
        Category category2 = new Category(null, "Ficção Científica", "Ficção Científica");
        Category category3 = new Category(null, "Biografias", "Livros de Biografias");

        Book book1 = new Book(null, "Clean Code", "Robert Martin", "Lorem Ipsum", "", category1);
        Book book2 = new Book(null, "Engenharia de Sopftwaare", "Louis V. Gerstner", "Lorem Ipsum", "", category1);
        Book book3 = new Book(null, "TVD", "S. Luis Grignion de Montfort", "Lorem Ipsum", "", category3);
        Book book4 = new Book(null, "Glórias de Maria", "Santo Afonso Maria de Logório", "Lorem Ipsum", "", category3);
        Book book5 = new Book(null, "Sereis uma só carne", "Prof. Felipe Aquino", "Lorem Ipsum", "", category3);

        category1.getBooks().addAll(Arrays.asList(book1, book2));
        category3.getBooks().addAll(Arrays.asList(book3, book4, book5));

        this.categoryRepository.saveAll(Arrays.asList(category1, category2, category3));
        this.bookRepository.saveAll(Arrays.asList(book1, book2, book3, book4, book5));
    }

}
