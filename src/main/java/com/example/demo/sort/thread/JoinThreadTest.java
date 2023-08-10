package com.example.demo.sort.thread;

/**
 * join 等待调用join的线程执行结束
 * */
public class JoinThreadTest {
    public static void main(String[] args) throws InterruptedException {
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("1");
                try {
                    Thread.sleep(3000);
                    System.out.println(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };
        Thread t = new Thread(r);
        t.start();
        System.out.println("start");
        t.join(1000);
        System.out.println("main");
    }
}
