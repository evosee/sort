package com.example.demo.sort.structure.nginx;

import java.util.List;

/**
 * @author chensai
 * @Description nginx加权轮询算法
 * @Date 2020/12/9 16:30
 */
public class NginxSort {
    private static final int TOTAL_TIME = 180;
    private static final int ONE_TIME = 5;

    public List<Plan> sort(List<Plan> plans) {
        //计算总时间如果有剩余时间用公益广告替代
        int sum = plans.stream().mapToInt(Plan::getSecond).sum();
        int surplus = TOTAL_TIME - sum;
        int publicWeight = surplus/5;
        Plan publicPlan = new Plan();
        return null;
    }

}
