package com.zhj.timer;

import java.util.Timer;

/**
 * Created by IntelliJ IDEA.
 * User: zhj
 * Date: 11-10-21
 * Time: 下午3:37
 * To change this template use File | Settings | File Templates.
 */
public class ThreadA {
    public static void main(String[] args) {
                  new Timer();
        new Timer();
        new Timer();
        new Timer();
        new Timer();
        new Timer();
        new Timer();
        new Timer();
        try {
               Thread.sleep(5000000);
            } catch (Exception e) {
            }
        ThreadB b = new ThreadB();
        b.start();
        System.out.println("b is start....");
        //synchronized (b)//括号里的b是什么意思,起什么作用?
        {
            try {

                System.out.println("Waiting for b to complete...");
                b.wait();//这一句是什么意思，究竟让谁wait?
                System.out.println("Completed.Now back to main thread");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("ThreadATotal is :" + b.total);
    }
}

class ThreadB extends Thread {
    int total;

    public void run() {
        try {
               Thread.sleep(5000);
            } catch (Exception e) {
            }
        synchronized (this) {
            System.out.println("ThreadB is running..");
            notify();
            for (int i = 0; i < 100; i++) {
                total += i;
                System.out.println("total is " + total);
            }

        }
    }
}
