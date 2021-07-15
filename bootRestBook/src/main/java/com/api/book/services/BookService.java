package com.api.book.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.api.book.Dao.BookRepository;
import com.api.book.entities.Book;

@Component
public class BookService {
	/*
	 * private static List<Book> list = new ArrayList<>(); static { list.add(new
	 * Book(21, "web devlopment", "abcd")); list.add(new Book(24, "AI -book",
	 * "abcd")); }
	 */

	@Autowired
	private BookRepository bookRepository;

//get all book
	public List<Book> getAllBooks() {
		return (List<Book>) this.bookRepository.findAll();

	}

//get single book by id
	public Book getBookById(int id) {

		Book book = null;
		try {
			// book = list.stream().filter(e -> e.getId() == id).findFirst().get();
			book = (Book) this.bookRepository.findById(id);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return book;
	}

//add data or create data
	public Book addBook(Book b) {
		Book re = this.bookRepository.save(b);
		System.out.println(b);
		return re;

	}

	// Delete book service
	public void deleteBook(int id) {
		/*
		 * list = list.stream().filter(e -> { if (e.getId() != id) { return true; } else
		 * { return false; } }).collect(Collectors.toList());
		 */

		this.bookRepository.deleteById(id);
	}

	// update book service
	public void updateBook(Book book, int id) {
		/*
		 * list = list.stream().map(b -> { if (b.getId() == id) {
		 * b.setTitle(book.getTitle()); b.setAuthor(book.getAuthor()); } return b;
		 * }).collect(Collectors.toList()); return book;
		 */
		book.setId(id);
		this.bookRepository.save(book);
	}

}
