package com.bridgelabz.Bookstore.dto;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDataDto {

	@NotNull
	private String bookName;

	@NotNull
	private String bookAuthor;

	private Double rating;

	@NotNull
	private Double bookPrice;

	@NotNull
	private Long bookQuantity;

	private String bookDescription;

	@NotNull
	private String bookImage;
}
