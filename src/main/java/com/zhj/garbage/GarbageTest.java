package com.zhj.garbage;

/**
 * Created by IntelliJ IDEA.
 * User: zhj
 * Date: 11-8-1
 * Time: 下午3:04
 * To change this template use File | Settings | File Templates.
 */
public class GarbageTest {


    public static void main(String[] args) {
        for (int i = 0; i < 300; i++)
            new Person();
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.gc();
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
