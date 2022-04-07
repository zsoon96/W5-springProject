package com.hanghae99.w5project.service;

import com.hanghae99.w5project.dto.FoodOrderDto;
import com.hanghae99.w5project.dto.FoodOrderRequestDto;
import com.hanghae99.w5project.dto.OrderDto;
import com.hanghae99.w5project.dto.OrderRequestDto;
import com.hanghae99.w5project.model.Food;
import com.hanghae99.w5project.model.FoodOrder;
import com.hanghae99.w5project.model.Orders;
import com.hanghae99.w5project.model.Restaurant;
import com.hanghae99.w5project.repository.FoodOrderRepository;
import com.hanghae99.w5project.repository.FoodRepository;
import com.hanghae99.w5project.repository.OrderRepository;
import com.hanghae99.w5project.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final RestaurantRepository restaurantRepository;
    private final FoodRepository foodRepository;
    private final FoodOrderRepository foodOrderRepository;

    // 주문 등록하기
    public OrderDto saveOrder(OrderRequestDto requestDto) {

        // OrderRequestDto > restaurantId으로 레스토랑 정보 불러오기
        // 예외처리 방법-1
        Restaurant restaurant = restaurantRepository.findById(requestDto.getRestaurantId()).orElseThrow(
                () -> new NullPointerException("해당 음식점이 존재하지 않습니다.")
        );
        // 레스토랑 정보 변수 초기화 선언
        String restaurantName = restaurant.getName();
        Long deliveryFee = restaurant.getDeliveryFee();
        int totalPrice = 0;



        // OrderDto와 Orders에 들어갈 FoodOrderDto 리스트가 필요하기 때문에 각각 생성
        // 리턴할 타입의 리스트 생성
        List<FoodOrderDto> foodOrderDto = new ArrayList<>();
        // 디비에 저장할 리스트 생성
        List<FoodOrder> foodOrder = new ArrayList<>();

        // OrderRequestDto > List<FoodOrderRequestDto> 값으로 음식 정보 불러오기
        // for each문
        for (FoodOrderRequestDto foodOrderRequestDto : requestDto.getFoods()) {
            // Food Id, quantity 불러오기
            Long foodId = foodOrderRequestDto.getId();
            int quantity = foodOrderRequestDto.getQuantity();
            // 주문 수량 검증 메소드
            foodQuantityCheck(quantity);

            // Food Id로 음식 정보 불러오기
            // 예외처리 방법-2
            Optional<Food> food = foodRepository.findById(foodOrderRequestDto.getId());
            // 음식 정보 변수 초기화
            String name = "";
            Long price = 0L;

            // 음식 정보 예외 처리
            if (food.isPresent()) {
                name = food.get().getName();
                price = food.get().getPrice();
            }

            // 총 금액 구하기
            price = price * quantity;
            totalPrice += price;



            // FoodOrder 리스트에 값 넣어주기 -> 테이블에 저장
            FoodOrder foodOrder1 = new FoodOrder(name, price, quantity);
            foodOrder.add(foodOrder1);
            foodOrderRepository.save(foodOrder1);

            // FoodOrderDto 리스트에 값 넣어주기 -> 리턴용이기 때문에 저장은 X
            FoodOrderDto foodOrderDto1 = new FoodOrderDto(name,price,quantity);
            foodOrderDto.add(foodOrderDto1);
        }

        // 최소 주문금액 검증 메소드
        minOrderPriceCheck(totalPrice, restaurant);

        // 최종 결제 금액 계산
        totalPrice += deliveryFee;


        // 리턴해줄 OrderDto 생성
        OrderDto orderList = new OrderDto(restaurantName,foodOrderDto, deliveryFee, totalPrice);
        // Orders 테이블에 넣어줄 Orders 객체 생성 후 레포지토리에 저장
        Orders orders = new Orders(restaurantName, foodOrder, deliveryFee, totalPrice);
        orderRepository.save(orders);

        return orderList;
    }

    // 주문 수량 검증 메소드
    public void foodQuantityCheck(int quantity) {
        if (quantity < 1 || quantity > 100) {
            throw new IllegalArgumentException("수량을 확인해주세요.");
        }
    }

    // 최소 주문금액 검증 메소드
    public void minOrderPriceCheck(int totalPrice, Restaurant restaurant) {
        if (restaurant.getMinOrderPrice() > totalPrice) {
            throw new IllegalArgumentException("최소 주문가격을 맞춰주세요.");
        }
    }

    // 주문 조회하기
    public List<Orders> getOrderList() {
        return orderRepository.findAll();
    }

}
