package com.bridgelabz.Bookstore.model;

import java.util.Optional;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.bridgelabz.Bookstore.dto.OrderAddressDto;

@Entity
public class OrderAddress {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	private String fullName;
	private String mobNo;
	private String address;
	private String city;
	private String State;
	private String type;
	
	public OrderAddress(OrderAddressDto orderAddressDto, Optional<OrderAddress> orderAddress) {
	
		
	}
}
