package com.bridgelabz.Bookstore.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.Bookstore.dto.CartDetailsDto;
import com.bridgelabz.Bookstore.exception.BookDataException;
import com.bridgelabz.Bookstore.exception.UserDataException;
import com.bridgelabz.Bookstore.model.BookData;
import com.bridgelabz.Bookstore.model.CartDetails;
import com.bridgelabz.Bookstore.model.UserData;
import com.bridgelabz.Bookstore.repository.BookDataRepo;
import com.bridgelabz.Bookstore.repository.CartDetailsRepository;
import com.bridgelabz.Bookstore.repository.UserDataRepository;
import com.bridgelabz.Bookstore.utils.Token;

@Service
public class CartDetailsService implements ICartDetails{
	
	@Autowired
	Token jwtToken;
	
	@Autowired
	CartDetailsRepository cartDetailsRepo;
	
	@Autowired
	UserDataRepository userDataRepo;
	
	@Autowired
	BookDataRepo bookDataRepo;
	
	
	public UserData isUserPresent(String token) {
        UUID userId = jwtToken.decodeJWT(token);
        Optional<UserData> userDetailsById = userDataRepo.findById(userId);
        
        if (!userDetailsById.isPresent()) {
            throw new UserDataException("User Not Found");
        }
        return userDetailsById.get();
    }
	
	
	@Override
    public List<CartDetails> getAllBooks(String Token) {
		System.out.println("Cart books"+Token);
       UserData userData = isUserPresent(Token);
       System.out.println("login"+userData);
      
       List<CartDetails> cartDetailsList = cartDetailsRepo.findCartDetailsByUserID(userData.getUserId());
//        if (cartDetailsList.size() == 0)
//            throw new BookDataException("No Books Found");
        return cartDetailsList;  
    }
	
	@Override
	public String addBookToCart(String Token, CartDetailsDto cartDto, UUID bookId) {
		 UserData userData = this.isUserPresent(Token);
		 UUID userId=userData.getUserId();
		 BookData bookData= bookDataRepo.findByBookId(bookId); 
		 System.out.println("Service cart details"+userData);
		 System.out.println("Service cart details"+bookData);
		 CartDetails cartDetails = new CartDetails(cartDto, bookData, userData);
		 System.out.println("Service cart details"+cartDetails);
		cartDetailsRepo.save(cartDetails);
		return "Book added to cart sucessfully";
	}

}
