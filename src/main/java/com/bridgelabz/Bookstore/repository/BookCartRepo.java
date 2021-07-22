package com.bridgelabz.Bookstore.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bridgelabz.Bookstore.model.BookCart;
import com.bridgelabz.Bookstore.model.CartDetails;

public interface BookCartRepo extends JpaRepository<BookCart, UUID>{
	
	 List<BookCart> findAllByCart(CartDetails cartDetails);

}
