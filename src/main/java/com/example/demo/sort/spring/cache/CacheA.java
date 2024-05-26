package com.example.demo.sort.spring.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 一个循环依赖的问题
 * 假如 A B 相互依赖，如果B在初始化过程中，反过来调用A的方法可能会抛出空指针
 * 因为此时A并没有初始化完毕，此时的A还是一个半成品，如果正好掉的方法引用了A中
 * 没有初始化的属性，则会抛出空指针。我觉得也因为如此，所以spring才建议构造函数初始化吧。
 * */

@Component
public class CacheA {
    @Autowired
    private CacheB cacheB;
    @Autowired
    private CacheC cacheC;

    public void operator() {
        cacheC.c();
    }
}
