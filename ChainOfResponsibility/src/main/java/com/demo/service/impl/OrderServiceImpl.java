package com.demo.service.impl;
import com.demo.chain.AbstractChainContext;
import com.demo.entity.OrderDTO;
import com.demo.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final AbstractChainContext<OrderDTO> abstractChainContext;
    // public OrderServiceImpl(AbstractChainContext<OrderDTO> abstractChainContext){
    //     this.abstractChainContext = abstractChainContext;
    // }

    @Override
    public void processOrder(OrderDTO orderDTO) {
        abstractChainContext.handler("OrderChainFilter",orderDTO);
        System.out.println("订单校验完成");
    }


}
