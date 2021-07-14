package com.bridgelabz.Bookstore.service;

import javax.mail.MessagingException;

import com.bridgelabz.Bookstore.dto.UserDataDTO;
import com.bridgelabz.Bookstore.dto.UserLoginDTO;
import com.bridgelabz.Bookstore.model.UserData;

public interface IUserDataService {
	
	public UserData createNewUser(UserDataDTO userdto);
	public void verifyEmail(String tokenId);
	public String userLogin(UserLoginDTO userLoginDto);
	public String sendPasswordResetLink(String emailId) throws MessagingException;
	public String resetPassword(String password, String urlToken);
}
