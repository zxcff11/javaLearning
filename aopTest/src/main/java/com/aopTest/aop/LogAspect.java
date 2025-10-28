package com.aopTest.aop;

import com.aopTest.annotation.GlobalInterceptor;
import com.aopTest.annotation.VerifyParam;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.boot.autoconfigure.session.NonUniqueSessionRepositoryException;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component // 纳入IoC容器
@Aspect // 指定该类为切面类
public class LogAspect {

    // 日期格式化器
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss SSS");

    @Pointcut("@annotation(com.aopTest.annotation.GlobalInterceptor)")
    private void requestInterceptor() {

    }


    // 环绕通知
    @Around("requestInterceptor()")
    public Object sysLog(ProceedingJoinPoint point) throws Throwable {
        Object target = point.getTarget();
        Object[] args = point.getArgs();
        String methodName = point.getSignature().getName();
        Class<?>[] parameterTypes = ((MethodSignature) point.getSignature()).getMethod().getParameterTypes();
        Method method = target.getClass().getMethod(methodName, parameterTypes);
        GlobalInterceptor annotation = method.getAnnotation(GlobalInterceptor.class);
        if (annotation.checkValue()) {
            checkValue(method, args);
        }

        Object pointResult = point.proceed();
        //增加频次校验
        return pointResult;
    }

    private void checkValue(Method method, Object[] args) {
        Parameter[] parameters = method.getParameters();
        for (int i = 0; i < parameters.length; i++) {
            Parameter parameter = parameters[i];
            Object value = args[i];
            VerifyParam verifyParam = parameter.getAnnotation(VerifyParam.class);

            if (verifyParam.required()) {
                if (value == null) {
                    throw new NullPointerException();
                }
            }
            Integer length = value == null ? 0 : value.toString().length();
            if (verifyParam.max() != -1 && length > 50) {
                throw new NumberFormatException();
            }

        }


    }
}
