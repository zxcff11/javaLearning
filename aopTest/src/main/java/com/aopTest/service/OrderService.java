package com.aopTest.service;

public interface OrderService {
    /**
     * 生成订单
     */
    void generate(Integer id, String name);

    /**
     * 订单详情
     */
    void detail(Integer id);
}