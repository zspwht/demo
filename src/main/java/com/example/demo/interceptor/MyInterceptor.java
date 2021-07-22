package com.example.demo.interceptor;


import java.lang.reflect.Method;

/**
 * @author zsp
 * @date 2021/7/22
 */
public class MyInterceptor implements Interceptor {

    @Override
    public boolean before(Object proxy, Object target, Method method, Object[] args) {
        System.out.println("发射方法前逻辑");
        return true;  //不反射被代理对象原有方法
    }

    @Override
    public void around(Object proxy, Object target, Method method, Object[] args) {
        System.out.println("取代了被代理对象的方法");
    }

    @Override
    public void after(Object proxy, Object target, Method method, Object[] args) {
        System.out.println("反射方法后逻辑");
    }
}
