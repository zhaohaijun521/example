package com.zhj.thread;

/**
 * Created by IntelliJ IDEA.
 * User: zhj
 * Date: 11-10-18
 * Time: 上午9:24
 * To change this template use File | Settings | File Templates.
 */
public class ThreadMain extends Thread {
    public int num;

    public static void main(String[] args) {
          try {
            Thread.sleep(10000);
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        new ThreadMain().start();

    }

    public void run() {
        for (int i = 0; i < 50; i++) {
            new Threada().run();
        }
    }
}

class Threada implements Runnable {
    public void run() {
        try {
            Thread.sleep(500);
            System.out.println(Thread.currentThread().getName());
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}