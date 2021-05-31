package com.example.demo.aspect;

import com.example.demo.annotation.Log;
import com.example.demo.bean.SysLog;
import com.example.demo.mapper.first.SySLogMapper;
import com.example.demo.utils.HttpContexUtils;
import com.example.demo.utils.IPUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @Author zsp
 * @Date 2021/5/31 14:55
 * @Version 1.0
 */
@Component
@Aspect
public class LogAspect {

    @Autowired
    private SySLogMapper sySLogMapper;
    @Pointcut("@annotation(com.example.demo.annotation.Log)")
    public void pointcut(){

    }

    @Around("pointcut()")
    public void around(ProceedingJoinPoint point){
        long beginTime = System.currentTimeMillis();
        try {
            //执行方法
            point.proceed();

        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        long time = endTime -beginTime;
        //保存日志
        saveLog(point,time);
    }

    private void saveLog(ProceedingJoinPoint point, long time) {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        SysLog sysLog = new SysLog();
        Log annotation = method.getAnnotation(Log.class);
        if(annotation!=null){
            sysLog.setOperation(annotation.value());
        }
        //请求的方法名
        String className = point.getTarget().getClass().getName();
        String methodName = signature.getName();
        sysLog.setMethod(className+"."+methodName+"()");

        Object[] args = point.getArgs();

        LocalVariableTableParameterNameDiscoverer u = new LocalVariableTableParameterNameDiscoverer();
        String[] parameterNames = u.getParameterNames(method);

        if(args!=null&&parameterNames!=null){
            String params = "";
            for (int i = 0; i < args.length; i++) {
                params += " "+parameterNames[i]+": "+args[i];
            }
            sysLog.setParams(params);
        }
        HttpServletRequest httpServletRequest = HttpContexUtils.getHttpServletRequest();
        sysLog.setIp(IPUtils.getIpAddr(httpServletRequest));
        sysLog.setUserName("zhangsan");
        sysLog.setTime((int)time);
        sysLog.setCreateTime(new Date());
        sySLogMapper.insert(sysLog);
    }
}
