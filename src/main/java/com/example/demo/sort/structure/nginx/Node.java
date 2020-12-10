package com.example.demo.sort.structure.nginx;

/**
 * @author chensai
 * @Description
 * @Date 2020/12/9 16:53
 */

public class Node {
    private int weight;//初始weight
    private int currentWeight;
    private int totalWeight;
  //  private int effectiveWeight;//当前生效的weight当同行业排斥的时候下降weight
    private Plan plan;

    public Node(int weight, int currentWeight, int totalWeight, Plan plan) {
        this.weight = weight;
        this.currentWeight = currentWeight;
        this.totalWeight = totalWeight;
        this.plan = plan;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getCurrentWeight() {
        return currentWeight;
    }

    public void setCurrentWeight(int currentWeight) {
        this.currentWeight = currentWeight;
    }

    public int getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(int totalWeight) {
        this.totalWeight = totalWeight;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }
}
