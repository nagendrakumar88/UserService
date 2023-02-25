package com.lcwd.user.service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table (name = "User")
public class User {
	
	@Id
	@Column(name = "ID")
	private String userId;
	@Column(name = "First_NAme")
	private String firstName;
	@Column(name = "Last_Name")
	private String lastName;
	@Column(name = "Email")
	private String email;
	@Column(name = "Password" ,length =10)
	private String  password;
	@Column(name = "Address")
	private String address;
	

}
