package com.bridgelabz.Bookstore.service;

import org.springframework.stereotype.Service;

import com.bridgelabz.Bookstore.dto.UserDataDTO;
import com.bridgelabz.Bookstore.model.UserData;

public interface IUserDataService {
	
	public UserData createNewUser(UserDataDTO userdto);
	public void verifyEmail(String tokenId);
}
