package com.wzy.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;

public class CglibProxyUtils {
    public static <T> T getProxyObject(T object, MethodInterceptor methodInterceptor) {
        return (T) Enhancer.create(object.getClass(), methodInterceptor);
    }
}
