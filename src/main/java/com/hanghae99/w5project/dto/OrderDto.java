package com.hanghae99.w5project.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
// 주문 요청에 대한 응답값을 담은 Dto - ResponseBody Sample
public class OrderDto {

    private String restaurantName;
    private List<FoodOrderDto> foods;
    private Long deliveryFee;
    private int totalPrice;

    public OrderDto(String restaurantName, List<FoodOrderDto> foodOrderDto, Long deliveryFee, int totalPrice) {
        this.restaurantName = restaurantName;
        this.foods=foodOrderDto;
        this.deliveryFee=deliveryFee;
        this.totalPrice = totalPrice;
    }
}
