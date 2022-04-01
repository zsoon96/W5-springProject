package com.hanghae99.w5project.model;

import com.hanghae99.w5project.dto.RestaurantRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor

public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Long minOrderPrice;

    @Column(nullable = false)
    private Long deliveryFee;

//    public Restaurant (RestaurantRequestDto requestDto) {
//        this.name = requestDto.getName();
//        this.minOrderPrice = requestDto.getMinOrderPrice();
//        this.deliveryFee = requestDto.getDeliveryFee();
//    }

    public Restaurant (String name, Long minOrderPrice, Long deliveryFee) {
        this.name = name;
        this.minOrderPrice = minOrderPrice;
        this.deliveryFee = deliveryFee;
    }
}
