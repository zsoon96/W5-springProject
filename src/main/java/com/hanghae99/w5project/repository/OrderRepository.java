package com.hanghae99.w5project.repository;

import com.hanghae99.w5project.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Orders, Long> {
}
