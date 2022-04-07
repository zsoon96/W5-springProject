package com.hanghae99.w5project.controller;

import com.hanghae99.w5project.dto.OrderDto;
import com.hanghae99.w5project.dto.OrderRequestDto;
import com.hanghae99.w5project.model.Orders;
import com.hanghae99.w5project.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class OrderController {

    private final OrderService orderService;
//    private final OrderService2 orderService2;

    // 주문 요청
    @PostMapping("/order/request")
    public OrderDto requestOrder(@RequestBody OrderRequestDto requestDto) {
        return orderService.saveOrder(requestDto);
    }

//     주문 조회
    @GetMapping("/orders")
    public List<Orders> showOrder(){
        return orderService.getOrderList();
    }
}
