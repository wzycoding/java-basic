package com.wzy.proxy.user;

import java.util.Random;

public class ToBUserServiceImpl implements ToBUserService {
    @Override
    public void login(String username, String password) {
        System.out.println(String.format("B端用户登录，用户名:%s, 密码：%s",
                username, password));

        Random random = new Random();
        try {
            Thread.sleep(random.nextInt(5000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
