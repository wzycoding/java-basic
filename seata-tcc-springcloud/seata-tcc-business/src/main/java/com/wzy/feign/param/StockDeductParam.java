package com.wzy.feign.param;

import lombok.Data;

@Data
public class StockDeductParam {
    private Integer productId;
    private Integer count;
}
