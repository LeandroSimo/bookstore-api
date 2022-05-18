package com.leandro.bookstore.dtos;

import com.leandro.bookstore.domain.Book;

import java.io.Serializable;

public class BookDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String title;

    public BookDto(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
    }

    public BookDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
