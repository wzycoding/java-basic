package com.wzy.feign.param;

import lombok.Data;

@Data
public class OrderCreateParam {
    private Integer productId;
    private Integer userId;
    private Integer payAmount;
    private Integer count;
}
