package com.bridgelabz.Bookstore.service;

import java.util.List;

import com.bridgelabz.Bookstore.dto.BookDataDto;
import com.bridgelabz.Bookstore.model.BookData;

public interface IBookService  {
	
	BookData addNewBook(BookDataDto dto);
	
	List<BookData> getAllBooks(Integer pageNo, Integer pageSize);
	
	List<BookData> getAllBookByPriceHighToLow(Integer pageNo, Integer pageSize);
	
	List<BookData> getAllBookByPriceLowToHigh(Integer pageNo, Integer pageSize);
	
	List<BookData> getAllBookByNewArrival(Integer pageNo, Integer pageSize);
	
	List<BookData> searchBookByName(String name);
	
	Long getBooksCount();

}
