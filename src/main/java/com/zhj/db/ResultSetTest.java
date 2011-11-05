package com.zhj.db;

import java.sql.*;

/**
 * Created by IntelliJ IDEA.
 * User: zhj
 * Date: 11-7-20
 * Time: 下午12:49
 * To change this template use File | Settings | File Templates.
 */
public class ResultSetTest extends Thread {
    public static Connection con = null;

    static {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@10.4.247.85:1521:igrp2", "carmot_sb_3", "carmot");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {

        Statement sm = null;
        Statement sm1 = null;
        Statement sm2 = null;
        Statement sm3 = null;
        Statement sm4 = null;
        ResultSet rs = null;
        try {
            //加载驱动
            System.out.println(con);
            sm = con.createStatement();
            int i=(int)(Math.random()*100);
            sm.execute("insert into TBCOMMENT(id,COMMENTID,TYPE) VALUES("+i+","+i+",9)");
            //ids.remove(0);
            /*
            sm1 = con.createStatement();
            sm1.execute("insert into TBCOMMENT(id,COMMENTID,TYPE) VALUES(11,11,9)");
            sm2 = con.createStatement();
            sm2.execute("insert into TBCOMMENT(id,COMMENTID,TYPE) VALUES(12,12,9)");
            sm3 = con.createStatement();
            sm3.execute("insert into TBCOMMENT(id,COMMENTID,TYPE) VALUES(13,13,9)");
            sm4 = con.createStatement();
            sm4.execute("insert into TBCOMMENT(id,COMMENTID,TYPE) VALUES(14,14,9)");
            */
            System.out.println(1 / 0);
            // rs.close();
            //sm.close();
            //con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        for(int i=0;i<4;i++)
            new ResultSetTest().start();
        try {
            Thread.sleep(10000000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
