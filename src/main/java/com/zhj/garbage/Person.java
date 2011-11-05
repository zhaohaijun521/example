package com.zhj.garbage;

/**
 * Created by IntelliJ IDEA.
 * User: zhj
 * Date: 11-8-1
 * Time: 下午3:33
 * To change this template use File | Settings | File Templates.
 */
public class Person {
     protected void finalize() throws Throwable {
            System.out.println("finalize");
            super.finalize();
        }
}
