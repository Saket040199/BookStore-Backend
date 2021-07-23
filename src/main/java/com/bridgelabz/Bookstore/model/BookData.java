package com.bridgelabz.Bookstore.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.bridgelabz.Bookstore.dto.BookDataDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "book_data")
public class BookData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "book_id")
	@Type(type = "uuid-char")
	private UUID bookId;

	@Column(name = "book_name")
	private String bookName;

	@Column(name = "book_author")
	private String bookAuthor;

	private Double rating;

	@Column(name = "book_price")
	private Double bookPrice;

	@Column(name = "book_quantity")
	private Long bookQuantity;

	@Column(name = "book_desciption")
	private String bookDescription;

	@Column(name = "book_image")
	private String bookImage;
	
	public LocalDateTime createdAt = LocalDateTime.now();
	
	@OneToMany(mappedBy="bookData",cascade = CascadeType.ALL)
    private List<BookCart> bookCarts = new ArrayList<>();

	public BookData(UUID bookId, BookDataDto bookDataDto) {
		this.bookId = bookId;
		this.bookName = bookDataDto.getBookName();
		this.bookAuthor = bookDataDto.getBookAuthor();
		this.rating = bookDataDto.getRating();
		this.bookPrice = bookDataDto.getBookPrice();
		this.bookQuantity = bookDataDto.getBookQuantity();
		this.bookDescription = bookDataDto.getBookDescription();
		this.bookImage = bookDataDto.getBookImage();
	}

	public BookData(BookDataDto bookDataDto) {
		this.bookName = bookDataDto.getBookName();
		this.bookAuthor = bookDataDto.getBookAuthor();
		this.rating = bookDataDto.getRating();
		this.bookPrice = bookDataDto.getBookPrice();
		this.bookQuantity = bookDataDto.getBookQuantity();
		this.bookDescription = bookDataDto.getBookDescription();
		this.bookImage = bookDataDto.getBookImage();
	}
}