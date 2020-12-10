package com.example.demo.sort.structure.nginx;

/**
 * @author chensai
 * @Description
 * @Date 2020/12/9 16:53
 */
public class Plan {
    private String trade;
    private int second;
    private Boolean reject;

    public Plan() {
    }

    public Plan(String trade, int second, Boolean reject) {
        this.trade = trade;
        this.second = second;
        this.reject = reject;
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

    public Boolean getReject() {
        return reject;
    }

    public void setReject(Boolean reject) {
        this.reject = reject;
    }
}
