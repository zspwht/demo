package com.example.demo.reflect.proxy;

import com.example.demo.reflect.ReflectServiceImpl;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * cglib动态代理示例
 */
public class CGLIBProxyExample implements MethodInterceptor {

    /**
     * 生成代理对象
     * @param cls
     * @return
     */
    public Object getProxy(Class cls){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(cls);
        enhancer.setCallback(this);
        return enhancer.create();
    }
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("调用真实对象前");
        Object invoke = methodProxy.invokeSuper(o, objects);
        System.out.println("调用真实对象后");
        return invoke;
    }

    public static void main(String[] args) {
        CGLIBProxyExample cglibProxyExample = new CGLIBProxyExample();
        ReflectServiceImpl reflectService = (ReflectServiceImpl)cglibProxyExample.getProxy(ReflectServiceImpl.class);
        reflectService.sayHello("李四");
    }
}
