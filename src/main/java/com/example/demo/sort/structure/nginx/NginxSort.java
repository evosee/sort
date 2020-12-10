package com.example.demo.sort.structure.nginx;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author chensai
 * @Description nginx加权轮询算法 https://blog.csdn.net/z69183787/article/details/108856272
 * @Date 2020/12/9 16:30
 */
public class NginxSort {
    public static void main(String[] args) {
        Plan a = new Plan("001",5,true,3,"A");
        Plan b = new Plan("001",15,false,3,"B");
        Plan c = new Plan("001",15,true,3,"C");
        Plan d = new Plan("003",15,true,2,"D");
        Plan e = new Plan("003",5,true,4,"E");
        Plan f = new Plan("004",5,true,1,"F");
        Plan g = new Plan("004",5,true,1,"G");
        List<Plan> plans = new ArrayList<>();
        plans.add(a);
        plans.add(b);
        plans.add(c);
        plans.add(d);
        plans.add(e);
        plans.add(f);
        plans.add(g);
        List<Plan> sort = new NginxSort().sort(plans);
        System.out.println(sort.toString());
    }
    private static final int TOTAL_TIME = 180;
    private static final int ONE_TIME = 5;

    public List<Plan> sort(List<Plan> plans) {
        //计算总时间如果有剩余时间用公益广告替代
        int sum = plans.stream().mapToInt(e-> e.getSecond()*e.getFrequency()).sum();
        int surplus = TOTAL_TIME - sum;
        int publicWeight = surplus/ONE_TIME;
        Plan publicPlan = new Plan("",5,false,publicWeight,"公益");
        plans.add(publicPlan);
        int maxWeight = plans.stream().mapToInt(Plan::getFrequency).sum();
        List<Node> nodes = plans.stream().map(e -> {
            Node node = new Node(e.getFrequency(), e.getFrequency(), maxWeight, e);
            return node;
        }).collect(Collectors.toList());
        List<Plan> r = new ArrayList<>(maxWeight);
        Node pre = null;
        for(int i=0;i<maxWeight;i++){
            //最后一个就不跳选了
            Integer times = i;
            if(i==maxWeight-1){
                times = null;
            }
            Node n = select(nodes,pre,times);
            pre = n;
            r.add(n.getPlan());
        }
        return r;
    }

    private Node select(List<Node> nodes,Node pre,Integer times) {
        //初始weight
        nodes.forEach(n->{
            n.setCurrentWeight(n.getWeight()+n.getCurrentWeight());
        });
        Collections.sort(nodes, (o1, o2) -> o2.getCurrentWeight()-o1.getCurrentWeight());
        Node node = findNode(nodes, pre,times);
        if(node==null){
            throw new RuntimeException("执行失败");
        }
        node.setCurrentWeight(node.getCurrentWeight()-node.getTotalWeight());
        return node;

    }

    private Node findNode(List<Node> nodes, Node pre,Integer times) {

            Iterator<Node> iterator = nodes.iterator();
            while (iterator.hasNext()){
                Node node = iterator.next();
                if(pre!=null&&(pre.getPlan().getReject()||node.getPlan().getReject())){
                    Plan plan = pre.getPlan();
                    String  preTrade = plan.getTrade();
                    String trade = node.getPlan().getTrade();
                    if(preTrade!=""&&preTrade.equals(trade)){
                        //继续找下一个
                        if(times!=null){
                            return findNode(nodes.subList(1,nodes.size()),pre,times);
                        }else return null;

                    }
                }
                return node;
            }


        return null;
    }

}
