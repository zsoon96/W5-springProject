package com.hanghae99.w5project.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

// 사용자가 입력한 주문 요청 데이터 - RequestBody Sample > 전체
public class OrderRequestDto {

    private Long restaurantId;
    private List<FoodOrderRequestDto> foods;

}
