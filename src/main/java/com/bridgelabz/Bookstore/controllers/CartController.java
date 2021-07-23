package com.bridgelabz.Bookstore.controllers;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.Bookstore.dto.ResponseDTO;
import com.bridgelabz.Bookstore.model.BookCart;
import com.bridgelabz.Bookstore.service.ICartService;

@CrossOrigin
@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    ICartService cartService;

    @PostMapping("/{quantity}/{bookId}")
    public ResponseEntity<ResponseDTO> saveBook(@PathVariable Integer quantity, @PathVariable UUID bookId, @RequestHeader(value = "token") String token) {
        String message = cartService.saveBooksToCart(quantity, bookId, token);
        ResponseDTO responseDTO = new ResponseDTO("Book Added to cart Sucessfully",message);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    @GetMapping("/getcart")
    public ResponseEntity<ResponseDTO> getBooks(@RequestHeader(value = "token") String token) {
        List<BookCart> cartDetailsList = cartService.getAllBooks(token);
        ResponseDTO responseDTO = new ResponseDTO( "Response Successful",cartDetailsList);
        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
}