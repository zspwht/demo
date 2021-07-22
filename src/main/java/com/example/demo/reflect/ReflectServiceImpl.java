package com.example.demo.reflect;

import jdk.nashorn.internal.ir.CallNode;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectServiceImpl {
    public void sayHello(String message){
        System.out.println("hello "+message);
    }


    public static void main(String[] args) {
        try {
            ReflectServiceImpl o = (ReflectServiceImpl)Class.forName("com.example.demo.reflect.ReflectServiceImpl").newInstance();
            Method sayHello = o.getClass().getMethod("sayHello", String.class);
            sayHello.invoke(o, "张三");

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
