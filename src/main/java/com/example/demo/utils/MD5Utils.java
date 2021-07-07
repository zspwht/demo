package com.example.demo.utils;

import org.apache.ibatis.logging.stdout.StdOutImpl;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * @Author zsp
 * @Date 2021/6/2 15:19
 * @Version 1.0
 */
public class MD5Utils {
    private static final String SALT = "abc";

    private static final String ALGORITH_NAME = "md5";

    private static final int HASH_ITERATIONS = 2;

    public static String encrypt(String password){
        String newPassword = new SimpleHash(ALGORITH_NAME,password, ByteSource.Util.bytes(SALT),HASH_ITERATIONS).toHex();
        return newPassword;
    }


    public static String encrypt(String username,String password){
        String newPassword = new SimpleHash(ALGORITH_NAME,password, ByteSource.Util.bytes(username+SALT),HASH_ITERATIONS).toHex();
        return newPassword;
    }

    public static void main(String[] args) {
        System.out.println(MD5Utils.encrypt("mrbird","123456"));
    }
}
