package com.hanghae99.w5project.repository;

import com.hanghae99.w5project.model.Food;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FoodRepository extends JpaRepository<Food, Long> {
//    List<Food> findByRestaurantIdAndName (Long restaurantId, String name);
    Optional<Food> findByRestaurantIdAndName(Long restaurantId, String name);

    List<Food> findByRestaurantId(Long restaurantId);
}