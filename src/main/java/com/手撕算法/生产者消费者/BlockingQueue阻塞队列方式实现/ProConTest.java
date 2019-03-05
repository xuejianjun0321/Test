package com.手撕算法.生产者消费者.BlockingQueue阻塞队列方式实现;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author xuejianjun<xuejianjun @ corp.netease.com>
 * @since 2019/03/05 11:37
 */
public class ProConTest {
    public static  void  main(String[] args) throws InterruptedException {

        //1.构建内存缓存区
        BlockingQueue<Integer> queue = new LinkedBlockingDeque<>();

        //2.建立线程池和线程
        ExecutorService service = Executors.newCachedThreadPool();
        Producer producer1 = new Producer(queue);
        Producer producer2 = new Producer(queue);
        Producer producer3 = new Producer(queue);
        Consumer consumer1 = new Consumer(queue);
        Consumer consumer2 = new Consumer(queue);
        Consumer consumer3 = new Consumer(queue);
        service.execute(producer1);
        service.execute(producer2);
        service.execute(producer3);
        service.execute(consumer1);
        service.execute(consumer2);
        service.execute(consumer3);

        //3.睡一会然后尝试停止生产者
        Thread.sleep(10*1000);
        producer1.stop();
        producer2.stop();
        producer3.stop();

        //4.睡一会然后关闭线程池
        Thread.sleep(3000);
        service.shutdown();
    }
}
