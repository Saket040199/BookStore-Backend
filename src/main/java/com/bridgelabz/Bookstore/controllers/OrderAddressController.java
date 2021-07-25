package com.bridgelabz.Bookstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.Bookstore.dto.OrderAddressDto;
import com.bridgelabz.Bookstore.dto.ResponseDTO;
import com.bridgelabz.Bookstore.service.IOrderAddressService;


@RestController
public class OrderAddressController {
	
	@Autowired
	private IOrderAddressService orderAddressService;

//	@PostMapping("/set/{addressId}")
//	public ResponseEntity<ResponseDTO> setAddress(@RequestHeader(value = "token") String token,
//			@RequestBody OrderAddressDto orderAddressDto) {
//
//		String cartData = orderAddressService.addAddress(token, orderAddressDto);
//
//		ResponseDTO responseDTO = new ResponseDTO("Response Successful", cartData);
//		return new ResponseEntity<>(responseDTO, HttpStatus.OK);
//	}
	
}
