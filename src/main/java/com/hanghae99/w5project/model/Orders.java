package com.hanghae99.w5project.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
// 주문 정보 응답 테이블 - ResponseBody Sample > 전체
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String restaurantName;

    @OneToMany // Orders 엔티티 기준 한 주문 건수의 여러 주문이기 때문에
    @JoinColumn(name = "FOODORDER_ID")
    private List<FoodOrder> foods;

    @Column(nullable = false)
    private Long deliveryFee;

    @Column(nullable = false)
    private int totalPrice;

    public Orders(String restaurantName, List<FoodOrder> foodOrder, Long deliveryFee, int totalPrice) {
        this.restaurantName=restaurantName;
        this.foods = foodOrder;
        this.deliveryFee=deliveryFee;
        this.totalPrice=totalPrice;
    }
}
