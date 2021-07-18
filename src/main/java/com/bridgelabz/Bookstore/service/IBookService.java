package com.bridgelabz.Bookstore.service;

import java.util.List;

import com.bridgelabz.Bookstore.dto.BookDataDto;
import com.bridgelabz.Bookstore.model.BookData;

public interface IBookService  {
	
	BookData addNewBook(BookDataDto dto);
	
	List<BookData> getAllBooks();
	
	Long getBooksCount();

}
