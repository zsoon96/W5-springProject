package com.hanghae99.w5project.service;

import com.hanghae99.w5project.dto.RestaurantRequestDto;
import com.hanghae99.w5project.model.Restaurant;
import com.hanghae99.w5project.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    // 음식점 조회
    public List<Restaurant> showRestaurant() {
        return restaurantRepository.findAll();
    }

    // 음식점 등록
    public Restaurant saveRestaurant(@RequestBody RestaurantRequestDto requestDto) {
        String name = requestDto.getName();
        Long minOrderPrice = requestDto.getMinOrderPrice();
        Long deliveryFee = requestDto.getDeliveryFee();

        if ( minOrderPrice < 1000 || minOrderPrice > 100000) {
            throw new IllegalArgumentException("허용값을 벗어났습니다.");
        }
        if ( minOrderPrice % 100 != 0) {
            throw new IllegalArgumentException("100원 단위로 입력해주세요.");
        }
        if ( deliveryFee < 0 || deliveryFee > 10000 ) {
            throw new IllegalArgumentException("허용값을 벗어났습니다.");
        }
        if ( deliveryFee % 500 != 0) {
            throw new IllegalArgumentException("500원 단위로 입력해주세요.");
        }

        Restaurant restaurant = new Restaurant(name, minOrderPrice, deliveryFee);
        return restaurantRepository.save(restaurant);
    }

}
