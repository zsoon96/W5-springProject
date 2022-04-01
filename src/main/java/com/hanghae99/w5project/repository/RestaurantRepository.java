package com.hanghae99.w5project.repository;

import com.hanghae99.w5project.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
