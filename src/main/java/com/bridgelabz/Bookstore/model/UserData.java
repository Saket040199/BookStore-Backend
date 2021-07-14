package com.bridgelabz.Bookstore.model;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.Type;

import com.bridgelabz.Bookstore.dto.UserDataDTO;

import lombok.Data;

@Entity
public @Data class UserData {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;
	
	private String fullName;
	private String phoneNumber;
	public String emailID;
	public String password;
	public boolean isVerified;
    public LocalDateTime createdAt = LocalDateTime.now();
     
    public UserData() { }
    
	public UserData(UserDataDTO userdto) {
		this.fullName = userdto.getFullName();
		this.phoneNumber = userdto.getPhoneNumber();
		this.emailID = userdto.getEmailId();
		this.password = userdto.getPassword();
	}

	public UserData(Long userId, UserDataDTO userdto) {
		this.userId = userId;
		this.fullName = userdto.getFullName();
		this.phoneNumber = userdto.getPhoneNumber();
		this.emailID = userdto.getEmailId();
		this.password = userdto.getPassword();
	}

    public UserData(String fullName, String phoneNumber, String emailID, String password) {
		this.fullName = fullName;
		this.phoneNumber = phoneNumber;
		this.emailID = emailID;
		this.password = password;
	}
}
