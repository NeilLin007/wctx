package com.cn.wctx.test.thread;/**
 * Created by chuyoule on 2018/5/16.
 */

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 测试线程池
 *
 * @author
 * @create 2018-05-16 10:56
 **/
public class TestThreadPool {

    @Test
    public void testFixedThreadPool() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Thread thread1 = new TestThread("thread1");
        Thread thread2 = new TestThread("thread2");
        Thread thread3 = new TestThread("thread3");
        Thread thread4 = new TestThread("thread4");
        Thread thread5 = new TestThread("thread5");
        Thread thread6 = new TestThread("thread6");
        executorService.submit(thread1);
        executorService.submit(thread2);
        executorService.submit(thread3);
        executorService.submit(thread4);
        executorService.submit(thread5);
        executorService.submit(thread6);
        executorService.shutdown();
        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSigleThreadPool() {
        ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();
        Thread thread1 = new TestThread("thread1");
        Thread thread2 = new TestThread("thread2");
        Thread thread3 = new TestThread("thread3");
        Thread thread4 = new TestThread("thread4");
        Thread thread5 = new TestThread("thread5");
        Thread thread6 = new TestThread("thread6");
        singleThreadPool.submit(thread1);
        singleThreadPool.submit(thread2);
        singleThreadPool.submit(thread3);
        singleThreadPool.submit(thread4);
        singleThreadPool.submit(thread5);
        singleThreadPool.submit(thread6);
        singleThreadPool.shutdown();
        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCachedTheadPool() {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        Thread thread1 = new TestThread("thread1");
        Thread thread2 = new TestThread("thread2");
        Thread thread3 = new TestThread("thread3");
        Thread thread4 = new TestThread("thread4");
        Thread thread5 = new TestThread("thread5");
        Thread thread6 = new TestThread("thread6");
        cachedThreadPool.submit(thread1);
        cachedThreadPool.submit(thread2);
        cachedThreadPool.submit(thread3);
        cachedThreadPool.submit(thread4);
        cachedThreadPool.submit(thread5);
        cachedThreadPool.submit(thread6);
        cachedThreadPool.shutdown();
        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSchedualTheadPool() {

    }

    public static void main(String[] args) {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(2);
        Thread thread1 = new TestThread("thread1");
        System.out.println(System.currentTimeMillis());
        scheduledThreadPool.scheduleWithFixedDelay(thread1, 1, 3, TimeUnit.SECONDS);
        try {
            Thread.sleep(100000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        scheduledThreadPool.shutdown();
        while(!scheduledThreadPool.isTerminated()){
        }
    }

}
