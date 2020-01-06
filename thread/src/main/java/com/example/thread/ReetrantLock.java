package com.example.thread;

import java.io.IOException;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author pengjw
 * @date 2019年10月18日 14:10
 * @description
 * @Version 1.0
 */

public class ReetrantLock {

    public void method1() {
        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
        try {
           System.in.read(); //阻塞
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("进入方法1"+Thread.currentThread().getName());
        reentrantLock.unlock();
    }


    public static void main(String[] args) {
        CyclicBarrier barrier0 = new CyclicBarrier(3);
        final ReetrantLock reetrantLock = new ReetrantLock();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("初始化A线程");
                    barrier0.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println("执行A线程");
                reetrantLock.method1();
            }
        }, "threadA").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("初始化B线程");
                    barrier0.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                System.out.println("执行B线程");
                reetrantLock.method1();
            }
        }, "threadB").start();
    }


}
