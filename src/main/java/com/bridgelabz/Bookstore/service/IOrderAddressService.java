package com.bridgelabz.Bookstore.service;

import java.util.List;
import java.util.UUID;

import com.bridgelabz.Bookstore.dto.OrderAddressDto;
import com.bridgelabz.Bookstore.model.OrderAddress;

public interface IOrderAddressService {

	List<OrderAddress> getAddress(String token);

	String addAddress(String token, OrderAddressDto orderAddressDto, UUID cartId);

}
