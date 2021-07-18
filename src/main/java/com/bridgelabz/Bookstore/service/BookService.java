package com.bridgelabz.Bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.Bookstore.dto.BookDataDto;
import com.bridgelabz.Bookstore.exception.BookDataException;
import com.bridgelabz.Bookstore.model.BookData;
import com.bridgelabz.Bookstore.repository.BookDataRepo;

@Service
public class BookService implements IBookService {
	
	@Autowired
	private BookDataRepo bookDataRepo;


	@Override
	public BookData addNewBook(BookDataDto dto) {
	Optional<BookData> findBook = bookDataRepo.findByBookName(dto.getBookName());
	if(findBook.isPresent()) {
	throw new BookDataException("Book is already present");
	}
	BookData bookData = new BookData(dto);
	return bookDataRepo.save(bookData);
	}

	@Override
	public List<BookData> getAllBooks() {
	return bookDataRepo.findAll();
	}

	@Override
	public Long getBooksCount() {
	return bookDataRepo.count();
	}
}
