package com.bridgelabz.Bookstore.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.Bookstore.dto.ResponseDTO;
import com.bridgelabz.Bookstore.dto.UserDataDTO;
import com.bridgelabz.Bookstore.model.UserData;
import com.bridgelabz.Bookstore.service.IUserDataService;

@RestController
@RequestMapping("/user")
public class UserDataControllers {
	
	@Autowired
	private IUserDataService userservice;
	
	@PostMapping("/create")
	public ResponseEntity<ResponseDTO> addUserData(@Valid @RequestBody UserDataDTO userdto) {
		UserData userdata=userservice.createNewUser(userdto);
		ResponseDTO respdto = new ResponseDTO("Created New User Successfully", userdata);
		return new ResponseEntity<ResponseDTO>(respdto, HttpStatus.OK);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping("/verify/email/{tokenId}")
	public ResponseEntity verifyEmail(@PathVariable String tokenId) {
		userservice.verifyEmail(tokenId);
		return new ResponseEntity("Email is successfully verified", HttpStatus.OK);	
	}
}
