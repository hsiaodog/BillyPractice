package com.billy.aop;

import com.billy.aop.advice.After;
import com.billy.aop.advice.Before;
import com.billy.aop.advice.Around;

import java.lang.reflect.Proxy;

public class AOPExample {
    public static void main(String[] args) {
        EmployeeService employeeService = (EmployeeService) Proxy.newProxyInstance(
                AOPExample.class.getClassLoader(),
                new Class[]{EmployeeService.class},
                new JdkAOPInvocationHandler(new EmployeeServiceImpl1(), new EmployeeAspect())
        );
        employeeService.print();
    }
}
/**
 *      goal: operation for interface EmployeeService {
 *          get()
 *          print()
 *          else...
 *      }
 *
 *      class EmployeeServiceAspect {
 *          @before
 *          public void beforeFunc() {
 *              do..
 *          }
 *          @after
 *          public void afterFunc() {
 *              do..
 *          }
 *      }
 *      1.  proxy.newInstance
 *          InvocationHandler {
 *              reflection scan EmployeeServiceAspect
 *                  mi:methods
 *                      check annotation
 *          }
 *      2.  Interceptor
 *              BeforeInterceptor
 *              AfterInterceptor
 *
 *      proxy.get() / print()
 *
 */

interface EmployeeService {
    int get();
    void print();
}

class EmployeeServiceImpl1 implements EmployeeService {

    @Override
    public int get() {
        System.out.println("this is get()");
        return 5;
    }

    @Override
    public void print() {
        System.out.println("this is print()");
    }
}

class EmployeeAspect {
    @Before
    public void beforeFunc1() {
        System.out.println("this is before 111");
    }
    @Around
    public Object aroundFunc2(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("-- -- --- this is around222 before -------");
        Object res = methodInvocation.proceed();
        System.out.println("-- -- --- this is around222 after -------");
        return res;
    }
    @Before
    public void beforeFunc2() {
        System.out.println("this is before 222");
    }
    @After
    public void afterFunc1() {
        System.out.println("this is after 111");
    }
    @After
    public void afterFunc2() {
        System.out.println("this is after 222");
    }
    @Before
    public void beforeFunc3() {
        System.out.println("this is before 333");
    }@Before
    public void beforeFunc4() {
        System.out.println("this is before 444");
    }
    @After
    public void afterFunc3() {
        System.out.println("this is after 333");
    }
    @After
    public void afterFunc5() {
        System.out.println("this is after 555");
    }
    @Around
    public Object aroundFunc1(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("-- -- --- this is around111 before -------");
        Object res = methodInvocation.proceed();
        System.out.println("-- -- --- this is around111 after -------");
        return res;
    }
}
