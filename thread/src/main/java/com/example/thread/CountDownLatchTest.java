package com.example.thread;

import java.util.concurrent.*;

/**
 * @author pengjw
 * @date 2019年11月01日 9:41
 * @description 线程组等待测试类
 * @Version 1.0
 */

public class CountDownLatchTest {

    // 模拟了100米赛跑，10名选手已经准备就绪，只等裁判一声令下。当所有人都到达终点时，比赛结束。
    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        // 开始的倒数锁
        final CountDownLatch begin = new CountDownLatch(10);

        final CountDownLatch middleLatch = new CountDownLatch(10);

        final CountDownLatch mainLatch = new CountDownLatch(1);

        // 结束的倒数锁
        //final CountDownLatch end = new CountDownLatch(10);

        CyclicBarrier cyclicBarrier = new CyclicBarrier(11);

        // 十名选手
        final ExecutorService exec = Executors.newFixedThreadPool(10);

        for (int index = 0; index < 10; index++) {
            final int NO = index + 1;
            Runnable run = new Runnable() {
                public void run() {
                    try {
                        // 如果当前计数为零，则此方法立即返回。
                        // 等待
                         System.out.println("No." + NO + "create");
                        // begin.await();
                        middleLatch.countDown();
                        cyclicBarrier.await();
                        Thread.sleep((long) (Math.random() * 10000));
                        System.out.println("No." + NO + " arrived");
                    } catch (InterruptedException e) {
                    }catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                    finally {
                        // 每个选手到达终点时，end就减一
                       // end.countDown();
                        //System.out.println("NO="+NO);
                        begin.countDown();

                    }
                }
            };
            exec.submit(run);
        }

        middleLatch.await();
        System.out.println("Game Start");
        // begin减一，开始游戏
       // begin.countDown();
        try {
            cyclicBarrier.await();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }

           begin.await();

        // 等待end变为0，即所有选手到达终点
        //end.await();
        System.out.println("Game Over");
        exec.shutdown();
    }

}
