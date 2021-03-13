package com.leandro.bookstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leandro.bookstore.domain.Livro;

@Repository
public interface LivroRepository2  extends JpaRepository<Livro, Integer>{

}
