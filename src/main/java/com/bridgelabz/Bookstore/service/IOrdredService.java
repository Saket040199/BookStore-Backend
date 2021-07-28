package com.bridgelabz.Bookstore.service;

import java.util.UUID;

public interface IOrdredService {

	Long generateId(String token, UUID cartId);

}
