package com.vishnu.RestaurantManagementService.repo;

import com.vishnu.RestaurantManagementService.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<Order,Integer> {


}
