package com.billy.aop.Interceptor;

import com.billy.aop.MethodInvocation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AfterMethodInterceptor implements MethodInterceptor {
    private Object aspectObj;
    private Method aspectMethod;

    public AfterMethodInterceptor(Object aspectObj, Method aspectMethod) {
        this.aspectObj = aspectObj;
        this.aspectMethod = aspectMethod;
    }

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable { // use throwable for easier handling with exceptions
        Object result = methodInvocation.proceed();
        aspectMethod.setAccessible(true); //avoiding this is not public
        aspectMethod.invoke(aspectObj);
        return result; // run the proceed() first, then run the code.
    }
}
