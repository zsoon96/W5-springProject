package com.hanghae99.w5project.service;

import com.hanghae99.w5project.dto.FoodRequestDto;
import com.hanghae99.w5project.model.Food;
import com.hanghae99.w5project.repository.FoodRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class FoodService {

    private final FoodRepository foodRepository;

    @Autowired
    public FoodService(FoodRepository foodRepository){
        this.foodRepository = foodRepository;
    }

    // 음식 조회
    // restaurantId 값 기준으로 음식명들을 불러오기
    public List<Food> showFood(Long restaurantId) {
        return foodRepository.findByRestaurantId(restaurantId);
    }

    @Transactional
    // 음식 등록
    // 음식점 Id와 음식명,가격이 담긴 dto를 가지고 반환 타입이 없는 메소드를 실행
    public void saveFood (Long restaurantId, List<FoodRequestDto> requestDto){

        // 리스트에 담긴 값들을 반복문을 통해서 하나씩 꺼내와 중복과 조건 검사하기
        for (int i=0; i < requestDto.size(); i++) {
            // 조건문을 돌릴 변수들 선언
            String name = requestDto.get(i).getName();
            Long price = requestDto.get(i).getPrice();

            //DB에서 음식점 Id값으로 음식명 불러와서 foodlist에 담아주기 // name 파라미터값 !!!!!!!!!
            Optional<Food> foodlist = foodRepository.findByRestaurantIdAndName(restaurantId, name);

            // 음식명이 존재하면 예외처리 해주기 (중복검사)
            if (foodlist.isPresent()) {
                throw new IllegalArgumentException("해당 메뉴가 이미 존재합니다.");
            }

            if ( price < 100 || price > 1000000) {
                throw new IllegalArgumentException("허용값을 벗어났습니다.");
            }

            if ( price % 100 != 0) {
                throw new IllegalArgumentException("100원 단위로 입력해주세요.");
            }
            Food food = new Food (restaurantId,name,price);
            foodRepository.save(food);
        }

        // requestDto의 요소를 반복해서 foodlist에 담아주기
        // Food 타입으로 food 객체 생성하기
        // 생성한 객체에는 음식점 Id와 리스트에 담긴 음식명, 가격 담아주기
//        for (FoodRequestDto foodlist : requestDto ) {
//            Food food = new Food (restaurantId,foodlist.getName(),foodlist.getPrice());
//            foodRepository.save();

    }
}
