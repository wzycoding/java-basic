package com.wzy.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

@SuppressWarnings("all")
public class JdkProxyUtils {

    public static <T> T getProxyObject(T object,
                                       InvocationHandler h) {
        return (T) Proxy.newProxyInstance(object.getClass().getClassLoader(),
                object.getClass().getInterfaces(), h);
    }
}
