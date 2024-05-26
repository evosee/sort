package com.example.demo.sort.spring.cache;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CacheB implements InitializingBean {
    @Autowired
    private CacheA cacheA;

    @Override
    public void afterPropertiesSet() throws Exception {
        cacheA.operator();
        System.out.println(1);
    }
}
