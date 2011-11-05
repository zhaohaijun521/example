package com.zhj.garbage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: zhj
 * Date: 11-10-16
 * Time: 上午10:32
 * To change this template use File | Settings | File Templates.
 */
public class MaxHeapTest {
    private static final int _1MB=1024*1024;
    public static void main(String[] args){
        /*
        byte[] b1=new byte[2*_1MB];
        byte[] b2=new byte[2*_1MB];
        byte[] b3=new byte[2*_1MB];
        byte[] b4=new byte[4*_1MB];
        try {
            Thread.sleep(100000000);
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }    */
        List<Null> personList=new ArrayList<Null>();
        //while(false){
            //personList.add(new Null());
        //}
        MaxHeapTest h=new MaxHeapTest();
        final User u=new User();
        u.userName="zhj";
         h.changeUser(u);
        System.out.println(u.userName);

    }
    public  void changeUser(User u){
        u.userName="syx";
    }
}

class Null{}

class User{
    public String userName;
}