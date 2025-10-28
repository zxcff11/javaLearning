package com.demo.service.handler;


import com.demo.entity.OrderDTO;


public interface OrderChainFilter<T extends OrderDTO> extends AbstractChainHandler<OrderDTO> {
    default String mark(){
        return "OrderChainFilter";
    }
}
