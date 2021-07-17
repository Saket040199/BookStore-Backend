package com.bridgelabz.Bookstore.controllers;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.Bookstore.dto.ResponseDTO;
import com.bridgelabz.Bookstore.dto.UserDataDTO;
import com.bridgelabz.Bookstore.dto.UserLoginDTO;
import com.bridgelabz.Bookstore.model.UserData;
import com.bridgelabz.Bookstore.service.IUserDataService;

@CrossOrigin
@RestController
@RequestMapping("/user")
@CrossOrigin
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
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping("/login")
    public ResponseEntity<ResponseDTO> userlogin(@Valid @RequestBody UserLoginDTO userLoginDTO, HttpServletResponse httpServletResponse) {
        String userLogin = userservice.userLogin(userLoginDTO);
        httpServletResponse.setHeader("Authorization", userLogin);
        ResponseDTO response = new ResponseDTO("Login successful", userLogin); 
        return new ResponseEntity<ResponseDTO>(response, HttpStatus.OK);
    }
	
	@PostMapping("/reset/link/{emailId}")
	public ResponseEntity<ResponseDTO> sendResetLink(@PathVariable(value = "emailId") String emailId) throws MessagingException {
		String link = userservice.sendPasswordResetLink(emailId);
		ResponseDTO respdto = new ResponseDTO("Reset Link Sent successfully", link);
		return new ResponseEntity<ResponseDTO>(respdto, HttpStatus.OK);
	}
	
	@PutMapping("/reset/password")
	public ResponseEntity<ResponseDTO> setNewPassword(@RequestParam(value = "password") String password,
			                                          @RequestParam(value = "token") String urltoken) {
		String setpassword = userservice.resetPassword(password, urltoken);
		ResponseDTO respdto = new ResponseDTO("New Password has been set successfully", setpassword);
		return new ResponseEntity<ResponseDTO>(respdto, HttpStatus.OK);	
	}
}
