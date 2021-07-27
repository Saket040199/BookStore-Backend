package com.bridgelabz.Bookstore.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OrderPalced {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID orderId;

}
