package com.billy.aop;

public interface MethodInvocation {
    Object proceed() throws Throwable; // proceed() is for going next element in the list which contains interceptors.
}
