package com.wzy.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.math.BigDecimal;

public class TimerLogInvocationHandler implements InvocationHandler {

    private Object targetObject;

    public TimerLogInvocationHandler(Object targetObject) {
        this.targetObject = targetObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        long startTime = System.currentTimeMillis();

        method.invoke(targetObject, args);

        long endTime = System.currentTimeMillis();

        System.out.println(String.format("class name %s, method name %s " +
                                " invoke cost %s s", targetObject.getClass().getName(), method.getName(),
                        BigDecimal.valueOf((endTime - startTime) / 1000d).setScale(2, BigDecimal.ROUND_DOWN)
                )
        );

        return proxy;
    }
}
