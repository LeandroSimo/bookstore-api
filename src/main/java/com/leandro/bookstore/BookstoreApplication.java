package com.leandro.bookstore;

import com.leandro.bookstore.domain.Book;
import com.leandro.bookstore.domain.Category;
import com.leandro.bookstore.repository.BookRepository;
import com.leandro.bookstore.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private BookRepository bookRepository;

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Category category1 = new Category(null, "Informática", "Livros de TI");
		Book book1 = new Book(null, "Clean Code", "Robert Martin","Lorem Ipsum",null,category1);
		category1.getBooks().addAll(Arrays.asList(book1));
		this.categoryRepository.saveAll(Arrays.asList(category1));
		this.bookRepository.saveAll(Arrays.asList(book1));
	}
}
