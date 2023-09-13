package com.wzy.feign;

import com.wzy.feign.param.StockDeductParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "stock-server")
public interface StockFeignClient {

    @PostMapping("/stock/inter/deductCount")
    Integer deductCount(@RequestBody StockDeductParam stockDeductParam);
}
