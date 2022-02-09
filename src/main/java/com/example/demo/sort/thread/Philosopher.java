package com.example.demo.sort.thread;

import lombok.Data;

/**
 * @author chensai
 * @Description  哲学家问题
 * 5个哲学家共用一张圆桌，分别坐在周围的5张椅子上，
 *
 * 在圆桌上有5个碗和5只筷子（注意是5只筷子，不是5双），
 *
 * 碗和筷子交替排列。他们的生活方式是交替地进行思考（thinking）和进餐（eating）。
 *
 * 平时，一个哲学家进行思考，饥饿时便试图取用其左右最靠近他的两只筷子，规定他必须先取左边的筷子，再取右边的筷子。
 * 只有在他拿到两只筷子时才能进餐。
 * 进餐完毕，放下筷子继续进行思考。
 *
 * 假如5位哲学家同时饥饿，各自拿起左边的筷子时，再去拿各自右边的筷子，因为无筷子可拿而陷入无期限等待（死锁）。
 * @Date 2022/2/9 9:44
 */
public class Philosopher implements Runnable{

    private Integer pos;

    public Philosopher(Integer pos){
        this.pos = pos;
    }
    @Override
    public void run() {
        while (true){
            if(pos==0){
                synchronized (Chopsticks.getByPos(4)){
                    synchronized (Chopsticks.getByPos(pos)){
                        System.out.println(pos+":eating");
                    }
                }
            }else{
                Chopsticks left = Chopsticks.getByPos(pos-1);
                Chopsticks right = Chopsticks.getByPos(pos);
                synchronized (left){
                    synchronized (right){
                        System.out.println(pos+":eating");
                    }
                }
            }
        }


    }
    /*@Data
    private static class Chopsticks{
        //定义五只筷子
        private Integer one = new Integer(1);
        private Integer two = new Integer(2);
        private Integer three = new Integer(3);
        private Integer four = new Integer(4);
        private Integer zero = new Integer(0);
        public
    }*/

    private  enum Chopsticks{
        ZERO,ONE,TWO,THREE,FOUR;
        public static Chopsticks getByPos(Integer pos){
            return values()[pos];
        }
    }

    public static void main(String[] args) {
        Thread one = new Thread(new Philosopher(0));
        Thread two = new Thread(new Philosopher(1));
        Thread three = new Thread(new Philosopher(2));
        Thread four = new Thread(new Philosopher(3));
        Thread five = new Thread(new Philosopher(4));
        one.start();
        two.start();
        three.start();
        four.start();
        five.start();
    }
}
