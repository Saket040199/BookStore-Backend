package com.bridgelabz.Bookstore.dto;

import lombok.Data;

@Data
public class ResetPasswordDto {
	
	private String token;
	private String password;
	private long otp;

}
