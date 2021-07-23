package com.bridgelabz.Bookstore.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.Bookstore.dto.BookDataDto;
import com.bridgelabz.Bookstore.dto.ResponseDTO;

import com.bridgelabz.Bookstore.model.BookData;
import com.bridgelabz.Bookstore.service.IBookService;

@CrossOrigin
@RestController
@RequestMapping("bookdata")
public class BookDataController {

	@Autowired
	private IBookService bookService;

	@PostMapping("/addbook")
	public ResponseEntity<ResponseDTO> addBook(@Valid @RequestBody BookDataDto bookDto) {
		BookData data = bookService.addNewBook(bookDto);
		ResponseDTO responseDto = new ResponseDTO("Book Added Successfully!!", data);
		return new ResponseEntity<ResponseDTO>(responseDto, HttpStatus.OK);
	}

	@GetMapping("/books/{pageNo}")
    public ResponseEntity<ResponseDTO> getBook(@PathVariable Integer pageNo) {
        List<BookData> bookDetailsList = bookService.getAllBooks(pageNo, 12);
        ResponseDTO responseDTO = new ResponseDTO( "Response Successful",bookDetailsList);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

	@GetMapping("/getbookcount")
	public ResponseEntity<ResponseDTO> getBookCount() {
		Long bookCount = bookService.getBooksCount();
		ResponseDTO responseDto = new ResponseDTO("Total Book Count!!", bookCount);
		return new ResponseEntity<ResponseDTO>(responseDto, HttpStatus.OK);
	}
	
	@GetMapping("/books/HighToLow/{pageNo}")
    public ResponseEntity<ResponseDTO> getBooksByHighToLow(@PathVariable Integer pageNo) {
        List<BookData> bookDetailsList = bookService.getAllBookByPriceHighToLow(pageNo, 12);
        ResponseDTO responseDTO = new ResponseDTO( "Response Successful",bookDetailsList);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
	
	@GetMapping("/books/LowToHigh/{pageNo}")
    public ResponseEntity<ResponseDTO> getBooksByLowToHigh(@PathVariable Integer pageNo) {
        List<BookData> bookDetailsList = bookService.getAllBookByPriceLowToHigh(pageNo, 12);
        ResponseDTO responseDTO = new ResponseDTO( "Response Successful",bookDetailsList);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
	
	@GetMapping("/books/Arraival/{pageNo}")
    public ResponseEntity<ResponseDTO> getBooksByNewArrival(@PathVariable Integer pageNo) {
        List<BookData> bookDetailsList = bookService.getAllBookByNewArrival(pageNo, 12);
        ResponseDTO responseDTO = new ResponseDTO( "Response Successful",bookDetailsList);
        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }
	
	@GetMapping("/find/{name}")
	public ResponseEntity<ResponseDTO>findByName(
						@PathVariable String name)
	{
		List<BookData> addressBookData = bookService.searchBookByName(name);
		ResponseDTO responseDto = new ResponseDTO("The following names are", addressBookData);
		return new ResponseEntity<ResponseDTO>(responseDto, HttpStatus.OK);
	}

}
