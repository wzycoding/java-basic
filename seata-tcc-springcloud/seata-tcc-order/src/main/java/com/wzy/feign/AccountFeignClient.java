package com.wzy.feign;

import com.wzy.feign.param.AccountDeductParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "account-server")
public interface AccountFeignClient {

    @PostMapping("/account/inter/deductAmount")
    Integer deductAmount(@RequestBody AccountDeductParam accountDeductParam);
}
