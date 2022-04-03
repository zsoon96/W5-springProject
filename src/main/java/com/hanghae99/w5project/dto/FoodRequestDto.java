package com.hanghae99.w5project.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@RequiredArgsConstructor
public class FoodRequestDto {

    private final Long restaurantId;
    private final String name;
    private final Long price;
}
