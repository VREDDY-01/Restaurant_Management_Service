package com.vishnu.RestaurantManagementService.controller;

import com.vishnu.RestaurantManagementService.model.FoodItem;
import com.vishnu.RestaurantManagementService.service.ItemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class FoodItemController {
	@Autowired
	ItemService itemService;

	@PostMapping("item/{id}")
	public String addItem(@RequestBody @Valid FoodItem item, @PathVariable Integer id){
		return itemService.addItem(item,id);
	}
	@GetMapping("items")
	public List<FoodItem> getItems(){
		return itemService.getItems();
	}
	@PutMapping("item/{id}/{itemId}")
	public String updateItem(@RequestBody @Valid FoodItem item, @PathVariable Integer id,@PathVariable Integer itemId){
		return itemService.updateItem(item,id,itemId);
	}
	@DeleteMapping("item/{id}/{itemId}")
	public String deleteItem(@PathVariable Integer id,@PathVariable Integer itemId){
		return itemService.deleteItem(id,itemId);
	}
}
