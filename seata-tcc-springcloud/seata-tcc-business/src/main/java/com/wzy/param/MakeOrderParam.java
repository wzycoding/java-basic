package com.wzy.param;

import lombok.Data;

@Data
public class MakeOrderParam {
    private Integer productId;
    private Integer userId;
    private Integer payAmount;
    private Integer count;
}
