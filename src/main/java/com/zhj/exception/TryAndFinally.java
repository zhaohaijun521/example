package com.zhj.exception;

/**
 * Created by IntelliJ IDEA.
 * User: zhj
 * Date: 11-10-13
 * Time: 下午1:51
 * To change this template use File | Settings | File Templates.
 */
public class TryAndFinally {
    public static void main(String[] args) {
       System.out.println('H' + 'a');
        System.out.println("return value of getValue(): " + getValue());
    }

    public static int getValue() {
        int i = 1;
        try {
            return i;
        } finally {
            i++;
        }
    }
}
