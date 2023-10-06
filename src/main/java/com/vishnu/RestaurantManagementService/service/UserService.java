package com.vishnu.RestaurantManagementService.service;

import com.vishnu.RestaurantManagementService.model.User;
import com.vishnu.RestaurantManagementService.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
	@Autowired
	UserRepo userRepo;

	public String addUser(User user) {
		userRepo.save(user);
		return "user Added";
	}

	public List<User> getUsers() {
		return userRepo.findAll();
	}

	public String updateUser(User user, Integer id) {
		User found = userRepo.findById(id).orElse(null);
		if (found!=null){
			found.setEmail(user.getEmail());
			found.setPassword(user.getPassword());
			userRepo.save(found);
			return "updated user";
		}
		return "Invalid Id";
	}

	public String deleteUser(Integer id) {
		userRepo.deleteById(id);
		return "one user deleted";
	}
}
