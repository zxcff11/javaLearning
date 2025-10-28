package com.demo.service.handler;


import com.demo.entity.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public final class OrderNotNegChainHandler implements OrderChainFilter<OrderDTO> {
    private static Logger log = LoggerFactory.getLogger(OrderNotNegChainHandler.class);

    @Override
    public void handle(OrderDTO orderDTO){
        if (orderDTO == null || orderDTO.getQuantity() <= 0) {
            log.info("订单为负 Order:"+ getOrder());
        }
    }

    @Override
    public int getOrder() {
        return 300;
    }
}
