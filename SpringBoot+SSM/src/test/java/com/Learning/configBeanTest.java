package com.Learning;

import com.Learning.entity.config.DatasourceConfig;
import com.Learning.entity.po.Car;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class configBeanTest {
    @Autowired
    private DatasourceConfig datasourceConfig;
    @Autowired
    Car benz ;
    @Test
    void contextLoads() {
        System.out.println(datasourceConfig);
    }
    @Test
    void LombokTest() {
        benz.setBrand("benz");
        benz.setPrice(12);
        System.out.println(benz);

    }



}
