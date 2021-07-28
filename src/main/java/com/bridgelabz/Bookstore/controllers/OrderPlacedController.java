package com.bridgelabz.Bookstore.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.Bookstore.service.IOrdredService;

@RestController
@CrossOrigin
public class OrderPlacedController {
	
	@Autowired
	private IOrdredService orderService;
	
//	@PostMapping("/orderPlaced/{cartId}")
//	public ResponseEntity<ResponseDTO> addBookToWishList(@RequestHeader(value = "token") String token,
//			@PathVariable UUID cartId) {
//		
//		Long orderId=orderService.generateId(token,cartId);
//
//		ResponseDTO responseDTO = new ResponseDTO("Response Successful", wishListData);
//		return new ResponseEntity<>(responseDTO, HttpStatus.OK);
//	}

}
