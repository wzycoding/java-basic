package com.wzy.proxy;

import com.wzy.proxy.user.ToCUserService;

import java.math.BigDecimal;

public class ToCUserProxyService implements ToCUserService {

    private ToCUserService toCUserService;

    public ToCUserProxyService(ToCUserService toCUserService) {
        this.toCUserService = toCUserService;
    }

    @Override
    public void login(String username, String password) {
        long startTime = System.currentTimeMillis();

        toCUserService.login(username, password);

        long endTime = System.currentTimeMillis();

        System.out.println(String.format("invoke cost %s s",
                        BigDecimal.valueOf((endTime - startTime) / 1000d).setScale(2, BigDecimal.ROUND_DOWN)
                )
        );
    }
}
