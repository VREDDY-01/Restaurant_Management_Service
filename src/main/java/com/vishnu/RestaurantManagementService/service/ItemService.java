package com.vishnu.RestaurantManagementService.service;

import com.vishnu.RestaurantManagementService.model.FoodItem;
import com.vishnu.RestaurantManagementService.model.Type;
import com.vishnu.RestaurantManagementService.model.User;
import com.vishnu.RestaurantManagementService.repo.FoodItemRepo;
import com.vishnu.RestaurantManagementService.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
	@Autowired
	FoodItemRepo foodItemRepo;
	@Autowired
	UserRepo userRepo;

	public String addItem(FoodItem item, Integer id) {
		User AdminUser = userRepo.findById(id).orElse(null);
		if (AdminUser != null && AdminUser.getType() == Type.ADMIN){
			foodItemRepo.save(item);
			return "item added";
		}
		return "User does not have the access";
	}

	public List<FoodItem> getItems() {
		return foodItemRepo.findAll();
	}

	public String updateItem(FoodItem item, Integer id, Integer itemId) {
		User AdminUser = userRepo.findById(id).orElse(null);
		if (AdminUser != null && AdminUser.getType() == Type.ADMIN){
			FoodItem found = foodItemRepo.findById(id).orElse(null);
			if (found!=null) {
				found.setTitle(item.getTitle());
				found.setDescription(item.getDescription());
				found.setPrice(item.getPrice());
				foodItemRepo.save(found);
				return "item has been updated";
			}
			return "item not found or Invalid Id";
		}
		return "User does not have the access";
	}

	public String deleteItem(Integer id, Integer itemId) {
		User AdminUser = userRepo.findById(id).orElse(null);
		if (AdminUser != null && AdminUser.getType() == Type.ADMIN){
			foodItemRepo.deleteById(id);
			return "item deleted";
		}
		return "User does not have the access";
	}
}
