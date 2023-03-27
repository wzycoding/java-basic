package com.wzy.proxy.cglib;


import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.math.BigDecimal;

public class TimerLogMethodInterceptor implements MethodInterceptor {

    /**
     * 拦截方法逻辑
     *
     * @param o           被增强的对象
     * @param method      被增强的方法
     * @param args        方法的参数
     * @param methodProxy 方法的代理对象
     * @return 方法返回值
     */
    @Override
    public Object intercept(Object o,
                            Method method,
                            Object[] args,
                            MethodProxy methodProxy) throws Throwable {
        long startTime = System.currentTimeMillis();

        Object returnValue = methodProxy.invokeSuper(o, args);

        long endTime = System.currentTimeMillis();

        System.out.println(String.format("method name %s " +
                                " invoke cost %s s", method.getName(),
                        BigDecimal.valueOf((endTime - startTime) / 1000d).setScale(2, BigDecimal.ROUND_DOWN)
                )
        );

        return returnValue;
    }
}
