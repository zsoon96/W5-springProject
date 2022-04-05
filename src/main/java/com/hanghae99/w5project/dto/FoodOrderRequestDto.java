package com.hanghae99.w5project.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
// 사용자가 입력한 주문 요청 데이터 - RequestBody Sample > foods 리스트
public class FoodOrderRequestDto {

    private Long id;
    private int quantity;

}
