package com.bridgelabz.Bookstore.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.Bookstore.exception.CartException;
import com.bridgelabz.Bookstore.exception.UserDataException;
import com.bridgelabz.Bookstore.model.BookCart;
import com.bridgelabz.Bookstore.model.BookData;
import com.bridgelabz.Bookstore.model.CartDetails;
import com.bridgelabz.Bookstore.model.UserData;
import com.bridgelabz.Bookstore.repository.BookCartRepo;
import com.bridgelabz.Bookstore.repository.BookDataRepo;
import com.bridgelabz.Bookstore.repository.CartDetailsRepo;
import com.bridgelabz.Bookstore.repository.UserDataRepository;
import com.bridgelabz.Bookstore.utils.Token;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CartService implements ICartService {

	@Autowired
	CartDetailsRepo cartRepo;

	@Autowired
	BookDataRepo bookDataRepo;

	@Autowired
	BookCartRepo bookCartRepository;

	@Autowired
	Token tokenGenerator;

	@Autowired
	UserDataRepository userRepository;

	public UserData isUserPresent(String token) {
		UUID userId = tokenGenerator.decodeJWT(token);
		Optional<UserData> userDetailsById = userRepository.findById(userId);
		if (!userDetailsById.isPresent()) {
			throw new UserDataException("User Not Found");
		}
		return userDetailsById.get();
	}

	@Override
	public List<BookCart> getAllBooks(String token) {
		UserData userDetails = isUserPresent(token);
		CartDetails cartDetails = cartRepo.findByUser(userDetails).get();
		List<BookCart> bookCartList = bookCartRepository.findAllByCart(cartDetails);
		if (bookCartList.size() == 0)
			throw new CartException("No Books Found In Cart", CartException.ExceptionType.NO_BOOK_FOUND);
		return bookCartList;
	}

	@Override
	public String saveBooksToCart(Integer quantity, UUID bookId, String token) {
		UserData userDetails = this.isUserPresent(token);
		
		Optional<BookData> optionalBookDetails = bookDataRepo.findById(bookId);
		if (!optionalBookDetails.isPresent())
			throw new CartException("Book Not Found", CartException.ExceptionType.NO_BOOK_FOUND);
		BookData bookDetails = optionalBookDetails.get();
		if (quantity > bookDetails.getBookQuantity())
			throw new CartException("Quantity Is Greater Than Stock",
					CartException.ExceptionType.ORDER_QUANTITY_GREATER_THEN_STOCK);
		BookCart bookCart = new BookCart(bookDetails, quantity);
		BookCart saveBookCart=bookCartRepository.save(bookCart);
		
		CartDetails cart = cartRepo.findByUser(userDetails).get();
		//List<BookCart> bookCartList = new ArrayList<>();
		//bookCartList.add(saveBookCart);
		cart.getBookCarts().add(saveBookCart);
		
		//cart.setBookCarts(bookCartList);
		bookCart.setCart(cart);
		
		cartRepo.save(cart);
		return "Book Successfully Added To Cart";
	}

}
