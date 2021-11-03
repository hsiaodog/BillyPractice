package com.billy.aop.Interceptor;

import com.billy.aop.MethodInvocation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BeforeMethodInterceptor implements MethodInterceptor{
    private Object aspectObj;
    private Method aspectMethod;

    public BeforeMethodInterceptor(Object aspectObj, Method aspectMethod) {
        this.aspectObj = aspectObj;
        this.aspectMethod = aspectMethod;
    }

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        aspectMethod.setAccessible(true);
        aspectMethod.invoke(aspectObj);
        return methodInvocation.proceed(); // run the code first, then run the proceed().
    }
}
