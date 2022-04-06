package com.hanghae99.w5project.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FoodOrderDto {

    private String name;
    private Long price;
    private int quantity;

    public FoodOrderDto(String name, Long price, int quantity) {
        this.name=name;
        this.price=price;
        this.quantity=quantity;
    }
}
