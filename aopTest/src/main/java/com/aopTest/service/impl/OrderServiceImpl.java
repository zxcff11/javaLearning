package com.aopTest.service.impl;

import com.aopTest.annotation.GlobalInterceptor;
import com.aopTest.annotation.VerifyParam;
import com.aopTest.service.OrderService;
import org.springframework.stereotype.Service;

@Service("orderService")
public class OrderServiceImpl implements OrderService {
    @GlobalInterceptor(checkValue = true)
    @Override
    public void generate(@VerifyParam(required = true) Integer id, @VerifyParam(max = 5) String name) {
        System.out.println("生成订单");
    }

    @Override
    public void detail(Integer id) {
        System.out.println("订单详情");
    }
}
