package com.手撕算法.生产者消费者.BlockingQueue阻塞队列方式实现;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author xuejianjun<xuejianjun @ corp.netease.com>
 * @since 2019/03/05 10:54
 */
public class Producer implements Runnable {

    private volatile boolean isRuning = true;
    private BlockingQueue<Integer> queue;
    private static AtomicInteger count = new AtomicInteger(); //总数，原子操作
    private static final int SLEEPTIME = 1000;

    public Producer(BlockingQueue<Integer> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        int data;
        Random random = new Random();
        System.out.println("start producer id =" + Thread.currentThread().getId());

        while (isRuning){
            try {
                //模拟延迟
                Thread.sleep(random.nextInt(SLEEPTIME));

                //往阻塞队列中添加数据
                data = count.incrementAndGet();
                System.out.println("producer"+ Thread.currentThread().getId() + "create data " + data + ",size:" + queue.size());
                if (!queue.offer(data,2, TimeUnit.SECONDS)){
                    System.err.println("failed to put data :" + data);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
    }

    public void stop(){
        isRuning = false;
    }
}
