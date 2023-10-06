package com.vishnu.RestaurantManagementService.repo;

import com.vishnu.RestaurantManagementService.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {
}
