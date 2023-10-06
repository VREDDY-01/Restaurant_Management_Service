package com.vishnu.RestaurantManagementService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class FoodItem {
	@Id
	private Integer id;
	private String title;
	private String description;
	private Float price;
}
