package com.api.book.Dao;

import org.springframework.data.repository.CrudRepository;

import com.api.book.entities.Book;

public interface BookRepository extends CrudRepository<Book,Integer> {
public BookRepository findById(int id);
}
