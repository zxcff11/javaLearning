package com.demo.service.handler;

import org.springframework.core.Ordered;

public interface AbstractChainHandler<T> extends Ordered {
    void handle(T t);
    String mark();
}
