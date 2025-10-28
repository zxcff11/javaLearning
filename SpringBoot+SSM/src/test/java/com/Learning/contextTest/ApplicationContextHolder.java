package com.Learning.contextTest;

import org.springframework.beans.BeansException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Map;

@SpringBootTest
@Component
public class ApplicationContextHolder implements ApplicationContextAware {
    private static ApplicationContext CONTEXT;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ApplicationContextHolder.CONTEXT = applicationContext;
    }
    public static <T> Map<String, T> getBeansOfType(Class<T> clazz){
        return CONTEXT.getBeansOfType(clazz);
    }
}
