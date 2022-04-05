package com.hanghae99.w5project.model;

import com.hanghae99.w5project.dto.FoodRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
// 주문한 음식 정보 테이블 - ResponseBody Sample > foods 리스트
public class FoodOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Long price;

    @Column(nullable = false)
    private int quantity;

    public FoodOrder(String name, Long price, int quantity) {
        this.name=name;
        this.price=price;
        this.quantity=quantity;
    }

    // 생성자는 Service에서 필요하면 생성해서 쓰기 ! = 먼저 만드려고 하지 말 것
//것   public FoodOrder (FoodRequestDto requestDto, int quantity){
//        // food 정보에 대한 내용은 foodRequestDto에 있기 때문에 Getter로 불러오기
//        this.name = requestDto.getName();
//        this.price = requestDto.getPrice() * quantity;
//        this.quantity = quantity;
//    }
}
