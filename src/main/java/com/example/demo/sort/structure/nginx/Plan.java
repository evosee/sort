package com.example.demo.sort.structure.nginx;

/**
 * @author chensai
 * @Description
 * @Date 2020/12/9 16:53
 */
public class Plan {
    private String trade;
    private int second;
    private boolean reject;
    private int frequency;
    private String name;


    public Plan(String trade, int second, boolean reject,int frequency,String name) {
        this.trade = trade;
        this.second = second;
        this.reject = reject;
        this.frequency = frequency;
        this.name = name;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public String getTrade() {
        return trade;
    }

    public void setTrade(String trade) {
        this.trade = trade;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public boolean getReject() {
        return reject;
    }

    public void setReject(boolean reject) {
        this.reject = reject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Plan{" +
                "trade='" + trade + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
