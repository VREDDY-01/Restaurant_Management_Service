package com.vishnu.RestaurantManagementService.controller;

import com.vishnu.RestaurantManagementService.model.Order;
import com.vishnu.RestaurantManagementService.repo.OrderRepo;
import com.vishnu.RestaurantManagementService.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class OrderController {
	@Autowired
	OrderService orderService;

	@PostMapping("order/{userId}")
	public String addOrder(@RequestBody @Valid Order order, @PathVariable Integer userId){
		return orderService.addOrder(order,userId);
	}
	@GetMapping("order/{userId}")
	public List<Order> getOrders(){
		return orderService.getOrders();
	}
	@PutMapping("order/{userId}/{orderId}")
	public String updateOrder(@PathVariable Integer userId,@PathVariable Integer orderId,@RequestBody @Valid Order order){
		return orderService.updateOrder(userId,orderId,order);
	}
	@DeleteMapping("order/{userId}/{orderId}")
	public String deleteOrder(@PathVariable Integer userId,@PathVariable Integer orderId){
		return orderService.deleteOrder(userId,orderId);
	}
}
