package com.wzy.proxy;

import com.wzy.proxy.jdkproxy.JdkProxyUtils;
import com.wzy.proxy.jdkproxy.TimerLogInvocationHandler;
import com.wzy.proxy.user.OtherUserService;

import java.lang.reflect.InvocationHandler;

public class ProxyMain {
    public static void main(String[] args) {
//        ToCUserService toCUserService = new ToCUserServiceImpl();
//        ToBUserService toBUserService = new ToBUserServiceImpl();
//        ToCUserService toCUserServiceStaticProxy = new ToCUserProxyService(toCUserService);
//        ToBUserService toBUserServiceStaticProxy = new ToBUserProxyService(toBUserService);
//
//        toCUserServiceStaticProxy.login("abc", "123");
//        toBUserServiceStaticProxy.login("dfe", "456");

//        ToCUserService toCUserService = new ToCUserServiceImpl();
//        ToBUserService toBUserService = new ToBUserServiceImpl();
//        InvocationHandler toCTimerInvocationHandler = new TimerLogInvocationHandler(toCUserService);
//        InvocationHandler toBTimerInvocationHandler = new TimerLogInvocationHandler(toBUserService);
//
//
//        ToCUserService toCProxyObject = JdkProxyUtils.getProxyObject(toCUserService, toCTimerInvocationHandler);
//        ToBUserService toBProxyObject = JdkProxyUtils.getProxyObject(toBUserService, toBTimerInvocationHandler);
//
//        toCProxyObject.login("abc", "123");
//        toBProxyObject.login("dfe", "456");

//        ToCUserService toCUserService = new ToCUserServiceImpl();
//        ToBUserService toBUserService = new ToBUserServiceImpl();
//
//        TimerLogMethodInterceptor timerLogMethodInterceptor = new TimerLogMethodInterceptor();
//
//        ToCUserService toCProxyObject = CglibProxyUtils.getProxyObject(toCUserService, timerLogMethodInterceptor);
//        ToBUserService toBProxyObject = CglibProxyUtils.getProxyObject(toBUserService, timerLogMethodInterceptor);
//
//        toCProxyObject.login("abc", "123");
//        toBProxyObject.login("dfe", "456");

        OtherUserService otherUserService = new OtherUserService();

        InvocationHandler timerLogInvocationHandler = new TimerLogInvocationHandler(otherUserService);

        OtherUserService otherUserProxyObject = JdkProxyUtils.getProxyObject(otherUserService, timerLogInvocationHandler);
        otherUserProxyObject.login("kfc", "123");
    }
}
