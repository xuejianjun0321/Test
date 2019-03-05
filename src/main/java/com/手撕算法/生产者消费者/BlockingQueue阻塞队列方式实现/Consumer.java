package com.手撕算法.生产者消费者.BlockingQueue阻塞队列方式实现;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * @author xuejianjun<xuejianjun @ corp.netease.com>
 * @since 2019/03/05 11:27
 */
public class Consumer implements Runnable {

    private BlockingQueue<Integer> queue;
    private static final  int SLEEPTIME = 1000;

    public Consumer(BlockingQueue<Integer> queue){
        this.queue =queue;
    }
    @Override
    public void run() {

        int data;
        Random random = new Random();
        System.out.println("start consumer id =" + Thread.currentThread().getId());

        while (true){
            try {
                Thread.sleep(random.nextInt(SLEEPTIME));

                if (! queue.isEmpty()){
                    data = queue.take();
                    System.out.println("consumer " + Thread.currentThread().getId() + " consume data " + data + ",size" + queue.size());
                }else {
                    System.out.println("Queue is empty ,consumer " + Thread.currentThread().getId() + "is waiting , size " + queue.size());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }

    }
}
