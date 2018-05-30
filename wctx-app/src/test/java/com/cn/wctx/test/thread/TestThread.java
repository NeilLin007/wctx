package com.cn.wctx.test.thread;/**
 * Created by chuyoule on 2018/5/16.
 */

/**
 * 测试用线程
 *
 * @author
 * @create 2018-05-16 10:58
 **/
public class TestThread extends Thread {
    private String name;

    public TestThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "正在执行......"+System.currentTimeMillis());
    }
}
