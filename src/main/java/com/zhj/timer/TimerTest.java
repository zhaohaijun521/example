package com.zhj.timer;

/**
 * Created by IntelliJ IDEA.
 * User: zhj
 * Date: 11-8-5
 * Time: 上午9:19
 * To change this template use File | Settings | File Templates.
 */

import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {
    private final Timer timer = new Timer();
    private final int minutes;

    public TimerTest(int minutes) {
        this.minutes = minutes;
    }

    public void start() {
         System.out.println(Thread.currentThread().getName());
        timer.schedule(new TimerTask1(), 1000,1000);
        timer.schedule(new TimerTask2(), 1000,1000);
    }

    public static void main(String[] args) {
        TimerTest eggTimer = new TimerTest(2);
        eggTimer.start();
    }
}

class TimerTask1 extends TimerTask {
    public void run() {

        System.out.println("1="+Thread.currentThread().getName());
    }
}
class TimerTask2 extends TimerTask {
    public void run() {
        try {
               Thread.sleep(50000);
            } catch (Exception e) {
            }
        System.out.println("2="+Thread.currentThread().getName());
    }
}