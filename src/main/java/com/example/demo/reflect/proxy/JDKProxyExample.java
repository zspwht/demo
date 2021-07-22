package com.example.demo.reflect.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * jdk动态代理示例
 */
public class JDKProxyExample implements InvocationHandler {

    private Object target = null;  //真实对象


    /**
     * 生成代理对象
     * @param target
     * @return
     */
    public Object bind(Object target){
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }

    /**
     * 代理方法
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("进入代理逻辑方法");
        System.out.println("在调度真实方法之前的服务");
        Object invoke = method.invoke(target, args);
        System.out.println("在调度真实方法之后的服务");
        return invoke;
    }

    public static void main(String[] args) {
        JDKProxyExample jdkProxyExample = new JDKProxyExample();
        HelloWorld proxy =(HelloWorld) jdkProxyExample.bind(new HelloWorldImpl());
        proxy.sayHello();
    }
}
