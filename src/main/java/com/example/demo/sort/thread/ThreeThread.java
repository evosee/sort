package com.example.demo.sort.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author chensai
 * @Description
 * @Date 2022/3/4 10:33
 * <p>
 * 交替打印 ABC
 */
public class ThreeThread {
    public static void main(String[] args) throws Exception {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition condition = reentrantLock.newCondition();
        Condition conditionb = reentrantLock.newCondition();
        Condition conditionc = reentrantLock.newCondition();

        Runnable a = () -> {

            while (true) {
                reentrantLock.lock();
                try {
                    conditionb.signalAll();
                    condition.await();
                    System.out.println("A");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                reentrantLock.unlock();

            }

        };
        Thread threadA = new Thread(a);
        Runnable b = () -> {
            while (true) {
                reentrantLock.lock();

                try {
                    conditionc.signalAll();
                    conditionb.await();
                    System.out.println("B");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                reentrantLock.unlock();
            }

        };
        Thread threadB = new Thread(b);
        Runnable c = () -> {
            while (true) {
                reentrantLock.lock();

                try {
                    condition.signalAll();
                    conditionc.await();
                    System.out.println("C");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                reentrantLock.unlock();

            }
        };
        Thread threadC = new Thread(c);


        threadA.start();
        threadB.start();
        threadC.start();
    }


}
