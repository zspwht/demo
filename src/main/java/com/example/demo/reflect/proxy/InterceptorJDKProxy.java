package com.example.demo.reflect.proxy;

import com.example.demo.interceptor.Interceptor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author zsp
 * @date 2021/7/22
 */
public class InterceptorJDKProxy implements InvocationHandler {

    private Object target; //真实对象
    private String interceptorClass = null;

    public InterceptorJDKProxy(Object target,String interceptorClass){
        this.target = target;
        this.interceptorClass = interceptorClass;
    }

    public static Object bind(Object target,String interceptorClass){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),new InterceptorJDKProxy(target,interceptorClass));
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if(interceptorClass == null){
            return method.invoke(target,args);
        }
        Object result = null;
        //通过反射生成拦截器
        Interceptor interceptor =(Interceptor) Class.forName(interceptorClass).newInstance();
        boolean before = interceptor.before(proxy, target, method, args);
        if(before){
            result = method.invoke(target,args);
        }else {
            interceptor.around(proxy,target,method,args);
        }
        interceptor.after(proxy,target,method,args);
        return result;
    }

    public static void main(String[] args) {
        HelloWorld helloWorld = (HelloWorld) InterceptorJDKProxy.bind(new HelloWorldImpl(),"com.example.demo.interceptor.MyInterceptor");
        helloWorld.sayHello();
    }
}
