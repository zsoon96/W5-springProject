//package com.hanghae99.w5project.service;
//
//import com.hanghae99.w5project.dto.*;
//import com.hanghae99.w5project.model.Food;
//import com.hanghae99.w5project.model.FoodOrder;
//import com.hanghae99.w5project.model.Orders;
//import com.hanghae99.w5project.model.Restaurant;
//import com.hanghae99.w5project.repository.FoodOrderRepository;
//import com.hanghae99.w5project.repository.FoodRepository;
//import com.hanghae99.w5project.repository.OrderRepository;
//import com.hanghae99.w5project.repository.RestaurantRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@RequiredArgsConstructor
//@Service
//public class OrderService2 {
//
//    private final RestaurantRepository restaurantRepository;
//    private final OrderRepository orderRepository;
//    private final FoodRepository foodRepository;
//    private final FoodOrderRepository foodOrderRepository;
//
//    //  주문 등록
//    public Orders saveOrder(OrderRequestDto requestDto) {
//
//        // restaurantId 값으로 레스토랑 정보 불러오기
//        Optional<Restaurant> restaurant = restaurantRepository.findById(requestDto.getRestaurantId());
//        // 레스토랑 정보 변수 초기화 선언
//        String restaurantName = "";
//        Long deliveryFee = 0L;
//        int totalPrice = 0;
//
//        // 레스토랑 정보 예외 처리
//        if (restaurant.isPresent()) { // restaurant 객체가 null이 아니면 조건문 안에 있는 변수 실행?
//            restaurantName = restaurant.get().getName();
//            deliveryFee = restaurant.get().getDeliveryFee();
//        }
//
//
//        // FoodOrderDto 객체 생성 (리스트 타입)
//        // 리스트 초기화 선언
//        List<FoodOrder> foodOrderList = new ArrayList<>();
//
//        // List<FoodOrderRequestDto> 값으로 음식 정보 불러오기
//        for (FoodOrderRequestDto foodOrderRequestDto : requestDto.getFoods()) {
//            // Food Id, quantity 불러오기
//            Long foodId = foodOrderRequestDto.getId();
//            int foodQuantity = foodOrderRequestDto.getQuantity();
//            // 주문 수량 검증 메소드
//            foodQuantityCheck(foodQuantity);
//
//            // Food Id로 음식 정보 불러오기
//            Optional<Food> food = foodRepository.findById(foodId);
//            // 음식 정보 변수 초기화
//            String foodName = "";
//            Long foodPrice = 0L;
//
//            // 음식 정보 예외 처리
//            if (food.isPresent()) {
//                foodName = food.get().getName();
//                foodPrice = food.get().getPrice();
//            }
//
//            // 총 금액 구하기
//            foodPrice = foodPrice * foodQuantity;
//            totalPrice += foodPrice;
//
//            // FoodOrderDto 객체 생성 ( 객체 생성 후 앞에서 만들어준 리스트에 추가 )
//            FoodOrder foodOrder = new FoodOrder(foodName, foodPrice,foodQuantity);
//            // FoodRepository에 저장.. 왜?
////            foodOrderRepository.save(foodOrderDto);
//            foodOrderList.add(foodOrder);
//        }
//
//        // 최소 주문가격 검증 메소드
//        minOrderPriceCheck(totalPrice, restaurant);
//
//        // 최종 결제 금액 계산
//        totalPrice += deliveryFee;
//
//        // Order 객체 생성 후 DB 저장
//        Orders orders = new Orders(restaurantName, foodOrderList, deliveryFee, totalPrice);
//
//        return orderRepository.save(orders);
//    }
//
//    // 주문 수량 검증
//    public void foodQuantityCheck(int quantity) {
//        if (quantity < 1 || quantity > 100 ){
//            throw new IllegalArgumentException("주문 수량을 확인해주세요.");
//        }
//    }
//
//    // 최소 주문가격 검증
//    public void minOrderPriceCheck(int totalPrice, Optional<Restaurant> restaurant) {
//        // 최소 주문 금액 불러오기
//        Long minOrderPrice = restaurant.get().getMinOrderPrice();
//        if ( minOrderPrice > totalPrice){
//            throw new IllegalArgumentException("최소 주문금액을 확인해주세요.");
//        }
//    }
//
//
//    // 주문 조회하기
//    public List<Orders> getOrderList() {
//        return orderRepository.findAll();
//    }
//
//}
//
//
