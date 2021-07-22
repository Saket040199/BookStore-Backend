package com.bridgelabz.Bookstore.model;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CartDetails {
	
	 	@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	 	@Type(type = "uuid-char")
	    public UUID id;

	    @OneToMany(mappedBy="cart",cascade = CascadeType.ALL)
	    private List<BookCart> bookCarts;

	    @OneToOne(cascade = CascadeType.ALL)
	    @JsonIgnore
	    @JoinColumn(name = "userId")
	    private UserData user;
	 	

}
