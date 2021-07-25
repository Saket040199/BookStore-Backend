package com.bridgelabz.Bookstore.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.Bookstore.exception.UserDataException;
import com.bridgelabz.Bookstore.model.UserData;
import com.bridgelabz.Bookstore.repository.OrderAddressRepository;
import com.bridgelabz.Bookstore.repository.UserDataRepository;
import com.bridgelabz.Bookstore.utils.Token;

@Service
public class OrderAddressService implements IOrderAddressService {

	@Autowired
	private Token jwtToken;

	@Autowired
	private UserDataRepository userDataRepo;

	@Autowired
	private OrderAddressRepository orderAddressRepo;

	public UserData isUserPresent(String token) {
		UUID userId = jwtToken.decodeJWT(token);
		Optional<UserData> userDetailsById = userDataRepo.findById(userId);

		if (!userDetailsById.isPresent()) {
			throw new UserDataException("User Not Found");
		}
		return userDetailsById.get();
	}



}
