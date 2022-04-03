package com.hanghae99.w5project.controller;

import com.hanghae99.w5project.dto.FoodRequestDto;
import com.hanghae99.w5project.model.Food;
import com.hanghae99.w5project.service.FoodService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class FoodController {

    private final FoodService foodService;

    @PostMapping("/restaurant/{restaurantId}/food/register")
    public void registerFood(@PathVariable Long restaurantId, @RequestBody List<FoodRequestDto> requestDto){
//        foodService.saveFood(restaurantId, requestDto);
        foodService.saveFood(restaurantId, requestDto);
//        return null;
    }

    @GetMapping("/restaurant/{restaurantId}/foods")
    public List<Food> showFood(@PathVariable Long restaurantId) {
        return foodService.showFood(restaurantId);
    }
}
