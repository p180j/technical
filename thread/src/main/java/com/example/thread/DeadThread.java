package com.example.thread;

/**
 * @author pengjw
 * @date 2019年10月18日 15:14
 * @description 死锁测试
 * @Version 1.0
 */

public class DeadThread {

   static class ThreadA {
        public void methodA() {
            System.out.println("A");
        }
    }

    static class ThreadB {
        public void methodB() {
            System.out.println("B");
        }
    }

    public static void main(String[] args) {
        final  ThreadA threadA = new ThreadA();
        final  ThreadB threadB = new ThreadB();

    new Thread(new Runnable() {
        @Override
        public void run() {
          synchronized (threadA){
              try {
                  Thread.sleep(10);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
              synchronized (threadB){
                  System.out.println("1");
              }
          }
        }
    },"THREAD-A").start();



        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (threadB){
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (threadA){
                        System.out.println("2");
                    }
                }
            }
        },"THREAD-B").start();

    }


}
