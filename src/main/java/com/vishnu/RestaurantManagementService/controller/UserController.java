package com.vishnu.RestaurantManagementService.controller;

import com.vishnu.RestaurantManagementService.model.User;
import com.vishnu.RestaurantManagementService.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class UserController {
	@Autowired
	UserService userService;
	@PostMapping("user")
	public String addUser(@RequestBody @Valid User user){
		return userService.addUser(user);
	}
	@GetMapping("users")
	public List<User> getUsers(){
		return userService.getUsers();
	}
	@PutMapping("user/{id}")
	public String updateUser(@RequestBody @Valid User user,@PathVariable Integer id){
		return userService.updateUser(user,id);
	}
	@DeleteMapping("user/{id}")
	public String deleteUser(@PathVariable Integer id){
		return userService.deleteUser(id);
	}
}
