package com.wzy.publisher;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PlaceOrderEvent {
    /**
     * 订单id
     */
    private Long orderId;

    /**
     * 支付价格
     */
    private Integer price;

    /**
     * 下单用户
     */
    private Long userId;
}
