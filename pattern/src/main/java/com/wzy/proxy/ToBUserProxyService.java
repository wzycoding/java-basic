package com.wzy.proxy;

import com.wzy.proxy.user.ToBUserService;

import java.math.BigDecimal;

public class ToBUserProxyService implements ToBUserService {

    private ToBUserService toBUserService;

    public ToBUserProxyService(ToBUserService toBUserService) {
        this.toBUserService = toBUserService;
    }

    @Override
    public void login(String username, String password) {
        long startTime = System.currentTimeMillis();

        toBUserService.login(username, password);

        long endTime = System.currentTimeMillis();

        System.out.println(String.format("invoke cost %s s",
                        BigDecimal.valueOf((endTime - startTime) / 1000d).setScale(2, BigDecimal.ROUND_DOWN)
                )
        );
    }
}
