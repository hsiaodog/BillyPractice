package com.billy.aop.Interceptor;

import com.billy.aop.MethodInvocation;

import java.lang.reflect.InvocationTargetException;

public interface MethodInterceptor {
    Object invoke(MethodInvocation methodInvocation) throws Throwable;
}
