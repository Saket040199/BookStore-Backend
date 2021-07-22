package com.bridgelabz.Bookstore.service;

import java.util.List;
import java.util.UUID;

import com.bridgelabz.Bookstore.model.BookCart;
import com.bridgelabz.Bookstore.model.CartDetails;
import com.bridgelabz.Bookstore.model.UserData;

public interface ICartService {
	
	List<BookCart> getAllBooks(String token);
	
    String saveBooksToCart(Integer quantity, UUID bookId, String token);
    

}
