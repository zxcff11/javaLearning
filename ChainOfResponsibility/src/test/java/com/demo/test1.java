package com.demo;

import com.demo.entity.OrderDTO;
import com.demo.service.OrderService;
import com.demo.service.impl.OrderServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class test1 {
    @Autowired
    private OrderService orderService;
    OrderDTO oorderDTO = new OrderDTO();

    @Test
    void testChainHandler() {
        orderService.processOrder(oorderDTO);
    }
}
