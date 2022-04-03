package com.hanghae99.w5project.model;

import com.hanghae99.w5project.dto.FoodRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor

public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private Long restaurantId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Long price;

    public Food (FoodRequestDto requestDto) {
        this.restaurantId = requestDto.getRestaurantId();
        this.name = requestDto.getName();
        this.price = requestDto.getPrice();
    }

    public Food (Long restaurantId, String name, Long price) {
        this.restaurantId = restaurantId;
        this.name = name;
        this.price = price;
    }

    public Food(Long restaurantId, FoodRequestDto requestDto) {
        this.restaurantId = restaurantId;
        this.name = requestDto.getName();
        this.price = requestDto.getPrice();
    }
}
