package com.zhj.serializable;

import java.io.*;

/**
 * Created by IntelliJ IDEA.
 * User: zhj
 * Date: 11-10-13
 * Time: 下午1:16
 * To change this template use File | Settings | File Templates.
 */
public class Test implements Serializable {

    private static final long serialVersionUID = 1L;

    public static int staticVar = 5;
    public transient int transientVar = 10;
    public  int var = 15;

    public static void main(String[] args) {
        try {
            //初始时staticVar为5
            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream("result.obj"));
            out.writeObject(new Test());
            out.close();

            //序列化后修改为10
            Test.staticVar = 10;
            new Test().transientVar=10;
            new Test().var=10;
            ObjectInputStream oin = new ObjectInputStream(new FileInputStream(
                    "result.obj"));
            Test t = (Test) oin.readObject();
            oin.close();

            //再读取，通过t.staticVar打印新的值
            System.out.println(t.staticVar);
            System.out.println(t.transientVar);
            System.out.println(t.var);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}