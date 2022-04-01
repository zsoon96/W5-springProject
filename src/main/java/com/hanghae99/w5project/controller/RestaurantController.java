package com.hanghae99.w5project.controller;

import com.hanghae99.w5project.dto.RestaurantRequestDto;
import com.hanghae99.w5project.model.Restaurant;
import com.hanghae99.w5project.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController // @Controller으로 하면 json파일로 변환이 안되서 오류 발생
public class RestaurantController {

    private final RestaurantService restaurantService;

    @PostMapping("/restaurant/register")
    public Restaurant registerRestaurant(@RequestBody RestaurantRequestDto requestDto){
        return restaurantService.saveRestaurant(requestDto);
    }

    @GetMapping("/restaurants")
    public List<Restaurant> showRestaurant () {
        return restaurantService.showRestaurant();
    }

}
