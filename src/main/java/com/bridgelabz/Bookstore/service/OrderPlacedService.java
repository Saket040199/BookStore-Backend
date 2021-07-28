package com.bridgelabz.Bookstore.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.Bookstore.dto.OrderAddressDto;
import com.bridgelabz.Bookstore.model.OrderAddress;
import com.bridgelabz.Bookstore.model.UserData;
//import com.bridgelabz.Bookstore.repository.OrderPlacedRepo;
import com.bridgelabz.Bookstore.repository.UserDataRepository;
import com.bridgelabz.Bookstore.utils.Token;

@Service
public class OrderPlacedService implements IOrdredService{
	
//	@Autowired
//	OrderPlacedRepo orderRepo;
	
	@Autowired
	private UserDataRepository userDataRepo;
	
	@Autowired
	Token jwtToken;
	
	@Override
	public Long generateId(String token, UUID cartId) {
		UUID userId = jwtToken.decodeJWT(token);
		Optional<UserData> userDetailsById = userDataRepo.findById(userId);
		
		return null;
	}

}
