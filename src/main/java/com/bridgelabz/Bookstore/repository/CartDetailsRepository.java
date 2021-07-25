package com.bridgelabz.Bookstore.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bridgelabz.Bookstore.model.CartDetails;
import com.bridgelabz.Bookstore.model.UserData;

public interface CartDetailsRepository extends JpaRepository<CartDetails, UUID>{
	
	//Optional<UserData> findByUserData(UserData userData);
	
//	@Query(value="select * from user_data where user_id:userId", nativeQuery = true)
//	List<CartDetails> findByUserId(UUID userId );

}
