package com.wzy.feign.param;

import lombok.Data;

@Data
public class AccountDeductParam {

    private Integer userId;
    private Integer amount;
}
