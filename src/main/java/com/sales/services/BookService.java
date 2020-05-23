package com.sales.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.models.Book;
import com.sales.repositories.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepo;
	
	private List<Book> booksList;
	
	//return list of books from book database
	
	public List<Book> getBooks()  
	{
		booksList = (List<Book>)bookRepo.findAll();
		
		return booksList;
	}
	
	//add new book object to database returns book instance
	
	public Book addBook(Book b)  
	{
		return bookRepo.save(b);
	}
	
	//find book by id, returns book instance if found
	
	public Book findBookById(Long id)  
	{
		return bookRepo.findOne(id);
	}

}
