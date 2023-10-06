package com.vishnu.RestaurantManagementService.repo;

import com.vishnu.RestaurantManagementService.model.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodItemRepo extends JpaRepository<FoodItem,Integer> {
}
