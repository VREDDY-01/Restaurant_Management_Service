package com.vishnu.RestaurantManagementService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
	@Id
	private Integer id;
	private String userName;
	private String password;
	@Email
	private String email;
	private Type type;
}
