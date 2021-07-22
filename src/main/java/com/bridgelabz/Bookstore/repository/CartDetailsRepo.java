package com.bridgelabz.Bookstore.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bridgelabz.Bookstore.model.CartDetails;
import com.bridgelabz.Bookstore.model.UserData;

public interface CartDetailsRepo extends JpaRepository<CartDetails, UUID>  {
	
	Optional<CartDetails> findByUser(UserData user);
	
}
