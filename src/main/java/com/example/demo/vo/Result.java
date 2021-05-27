package com.example.demo.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 接口返回的数据格式
 * @Author zsp
 * @Date 2021/5/26 10:15
 */
@Data
public class Result<T> implements Serializable {
    private static final long seriaVersionUID =1L;
    /**
     * 返回状态码
     */
    private Integer code;
    /**
     * 返回处理消息
     */
    private String message;
    /**
     * 是否成功标志
     */
    private boolean success;
    /**
     * 返回数据对象 data
     */
    private T Result;

    public Result(){

    }

    public Result<T> success(String message){
        this.message = message;
        this.code = 200;
        this.success = true;
        return this;
    }

    public static<T> Result<T> ok(){
        Result<T> result = new Result<T>();
        result.setCode(200);
        result.setSuccess(true);
        result.setMessage("成功");
        return  result;
    }

    public static<T> Result<T> ok(T data){
        Result<T> result = new Result<T>();
        result.setCode(200);
        result.setSuccess(true);
        result.setResult(data);
        return  result;
    }


    public static<T> Result<T> ok(String message,T data){
        Result<T> result = new Result<T>();
        result.setCode(200);
        result.setSuccess(true);
        result.setMessage(message);
        result.setResult(data);
        return  result;
    }
    public Result<T> error(String message){
        this.message = message;
        this.code = 500;
        this.success = false;
        return this;
    }

}
