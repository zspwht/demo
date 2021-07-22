package com.example.demo.interceptor;

import java.lang.reflect.Method;

/**
 * @author zsp
 * @date 2021/7/22
 * 拦截器接口
 */

public interface Interceptor {

    public boolean before(Object proxy, Object target, Method method,Object[] args);
    public void around(Object proxy, Object target, Method method,Object[] args);
    public void after(Object proxy, Object target, Method method,Object[] args);
}
