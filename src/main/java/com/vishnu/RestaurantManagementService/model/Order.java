package com.vishnu.RestaurantManagementService.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Orders")
public class Order {
	@Id
	private Integer orderId;
	@OneToMany
	@JoinColumn(name = "foodItemId")
	List<FoodItem> foodItem;
	private Integer quantity;
	private Status status;
	@ManyToOne
	@JoinColumn(name = "userId")
	User userId;
}
