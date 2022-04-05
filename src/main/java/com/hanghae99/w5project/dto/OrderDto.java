package com.hanghae99.w5project.dto;

import com.hanghae99.w5project.model.FoodOrder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
// 주문 요청에 대한 응답값을 담은 Dto - ResponseBody Sample
public class OrderDto {

    private final String restaurantName;
    private final List<FoodOrderDto> foods;
    private final Long deliveryFee;
    private final int totalPrice;

}
