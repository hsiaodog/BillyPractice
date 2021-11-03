package com.billy.aop;

import com.billy.aop.Interceptor.AfterMethodInterceptor;
import com.billy.aop.Interceptor.AroundMethodInterceptor;
import com.billy.aop.Interceptor.BeforeMethodInterceptor;
import com.billy.aop.Interceptor.MethodInterceptor;
import com.billy.aop.advice.After;
import com.billy.aop.advice.Around;
import com.billy.aop.advice.Before;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class JdkAOPInvocationHandler implements InvocationHandler {
    private Object aspectObj;
    private Object originObj;

    public JdkAOPInvocationHandler(Object originObj,Object aspectObj ) {
        this.aspectObj = aspectObj;
        this.originObj = originObj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Class<?> aspectClass = aspectObj.getClass(); // get all annotation in tbe
        List<MethodInterceptor> interceptors = new ArrayList<>();

        for (Method aspectMethod : aspectClass.getDeclaredMethods()) { // aspectMethods are all aspectMethod in EmployeeAspect (before and after) In here, it is for add the specific aspect into interceptors(List)
            for (Annotation declaredAnnotation : aspectMethod.getDeclaredAnnotations()) {
                MethodInterceptor methodInterceptor = null;
                if (declaredAnnotation.annotationType() == After.class) {
                    methodInterceptor = new AfterMethodInterceptor(aspectObj, aspectMethod);
                } else if (declaredAnnotation.annotationType() == Before.class) {
                    methodInterceptor = new BeforeMethodInterceptor(aspectObj, aspectMethod);
                } else if (declaredAnnotation.annotationType() == Around.class) {
                    methodInterceptor = new AroundMethodInterceptor(aspectObj, aspectMethod);
                }
                interceptors.add(methodInterceptor);
            }
        }

        MethodInvocation mi = new ProxyMethodInvocation(interceptors, originObj, method, args); // create the instance for running the proceed().
        return mi.proceed(); // running the proceed().
    }
}
