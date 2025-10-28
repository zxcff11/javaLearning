package com.demo.chain;

import com.demo.service.handler.AbstractChainHandler;
import org.springframework.beans.BeansException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class AbstractChainContext<T> implements CommandLineRunner, ApplicationContextAware {

    private ApplicationContext applicationContext;
    private Map<String, List<AbstractChainHandler>> abstractChainHandlerContainer;


    public void handler(String mark, T t) {
        List<AbstractChainHandler> abstractChainHandlers = abstractChainHandlerContainer.get(mark);
        // if (CollectionUtils.isEmpty(abstractChainHandlers)) {
        //     throw new RuntimeException(String.format("[%s] Chain of Responsibility ID is undefined.", mark));
        // }
        abstractChainHandlers.forEach(chainHandler -> chainHandler.handle(t));
    }

    @Override
    public void run(String... args) {

        // 验证责任链
        Map<String, AbstractChainHandler> chainHandlers = applicationContext.getBeansOfType(AbstractChainHandler.class);
        // chainHandlers.forEach((k, v) -> {
        //     List<AbstractChainHandler> chainHandlerList = abstractChainHandlerContainer.get(v.mark());
        //     if (CollectionUtils.isEmpty(chainHandlerList)) {
        //         chainHandlerList = new ArrayList<>();
        //     }
        //     chainHandlerList.add(v);
        //     abstractChainHandlerContainer.put(v.mark(), chainHandlerList);
        // });
        abstractChainHandlerContainer = chainHandlers.values().stream()
                .collect(Collectors.groupingBy(AbstractChainHandler::mark));
        abstractChainHandlerContainer.forEach((k,v)->{
            v.stream().sorted(Comparator.comparing(Ordered::getOrder));
        });
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
