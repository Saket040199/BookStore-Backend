package com.bridgelabz.Bookstore.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class BookCart implements Serializable {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Type(type = "uuid-char")
    private UUID bookCartID;
	
	@ManyToOne
    @JoinColumn
    private BookData bookData;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private CartDetails cart;

    private Integer quantity;
    
    public BookCart(BookData bookData, Integer quantity) {
        this.bookData = bookData;
        this.quantity = quantity;
    }

}
