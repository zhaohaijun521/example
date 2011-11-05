package com.zhj.distributetransaction;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: zhj
 * Date: 11-9-16
 * Time: 上午11:07
 * To change this template use File | Settings | File Templates.
 */
public class A {
    public static void main(String[] args) {
        List<B> messageUserList = new ArrayList<B>();
        for (int i = 0; i < 10; i++) {
            B b = new B();
            b.i = 1;
            messageUserList.add(b);
        }
        for (B bb : messageUserList) {
            System.out.println(bb.i);
        }
    }

}
