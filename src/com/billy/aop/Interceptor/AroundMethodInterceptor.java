package com.billy.aop.Interceptor;

import com.billy.aop.MethodInvocation;

import java.lang.reflect.Method;

// This logic is before + after
public class AroundMethodInterceptor implements MethodInterceptor{
    private Object aspectObj;
    private Method aspectMethod;

    public AroundMethodInterceptor(Object aspectObj, Method aspectMethod) {
        this.aspectObj = aspectObj;
        this.aspectMethod = aspectMethod;
    }

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        aspectMethod.setAccessible(true);
        return aspectMethod.invoke(aspectObj,methodInvocation);
    }
}
