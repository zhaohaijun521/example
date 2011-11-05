package com.zhj.thread;

/**
 * Created by IntelliJ IDEA.
 * User: zhj
 * Date: 11-11-2
 * Time: 下午3:01
 * To change this template use File | Settings | File Templates.
 */
import java.util.*;

public class ThreadSafeDemo {
    public static int demo(final List list, final int testCount) throws InterruptedException {
        ThreadGroup group = new ThreadGroup(list.getClass().getName() + "@" + list.hashCode());
        final Random rand = new Random();

        Runnable listAppender = new Runnable() {
            public void run() {
                try {
                    Thread.sleep(rand.nextInt(2));
                } catch (InterruptedException e) {
                    return;
                }
                list.add("0");
            }
        };

        for (int i = 0; i < testCount; i++) {
            new Thread(group, listAppender, "InsertList-" + i).start();
        }

        while (group.activeCount() > 0) {
            Thread.sleep(10);
        }

        return list.size();
    }
    public static void main(String[] args) throws InterruptedException {
        List unsafeList = new ArrayList();
        List safeList = Collections.synchronizedList(new ArrayList());
        /*final int N = 10000;
        for (int i = 0; i < 10; i++) {
            unsafeList.clear();
            safeList.clear();
            int unsafeSize = demo(unsafeList, N);
            int safeSize = demo(safeList, N);
            System.out.println("unsafe/safe: " + unsafeSize + "/" + safeSize);
        }*/
        unsafeList.add("1");
        unsafeList.add("2");
        Iterator it=unsafeList.iterator();
        while (it.hasNext())
            it.next();
    }
}
