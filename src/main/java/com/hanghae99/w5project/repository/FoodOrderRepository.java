package com.hanghae99.w5project.repository;

import com.hanghae99.w5project.model.FoodOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodOrderRepository extends JpaRepository<FoodOrder, Long> {
}
