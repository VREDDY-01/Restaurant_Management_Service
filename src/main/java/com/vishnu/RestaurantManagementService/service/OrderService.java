package com.vishnu.RestaurantManagementService.service;

import com.vishnu.RestaurantManagementService.model.Order;
import com.vishnu.RestaurantManagementService.model.Type;
import com.vishnu.RestaurantManagementService.model.User;
import com.vishnu.RestaurantManagementService.repo.OrderRepo;
import com.vishnu.RestaurantManagementService.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
	@Autowired
	OrderRepo orderRepo;
	@Autowired
	UserRepo userRepo;

	public String addOrder(Order order, Integer userId) {
		User user =userRepo.findById(userId).orElse(null);
		if (user!=null && user.getType() == Type.NORMAL){
			orderRepo.save(order);
			return "order saved";
		}
		return "This User do not have access";
	}

	public List<Order> getOrders() {
		return orderRepo.findAll();
	}

	public String updateOrder(Integer userId, Integer orderId,Order order) {
		User user =userRepo.findById(userId).orElse(null);
		if (user!=null && user.getType() == Type.NORMAL){
			Order found = orderRepo.findById(orderId).orElse(null);
			if (found!=null){
				found.setQuantity(order.getQuantity());
				found.setStatus(order.getStatus());
				orderRepo.save(found);
				return "order updated";
			}
			return "Invalid order Id";
		}
		return "This User do not have access";
	}

	public String deleteOrder(Integer userId,Integer orderId) {
		User user =userRepo.findById(userId).orElse(null);
		if (user!=null && user.getType() == Type.NORMAL){
			orderRepo.deleteById(orderId);
			return "order deleted";
		}
		return "This User do not have access";
	}
}
