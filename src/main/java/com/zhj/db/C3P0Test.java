package com.zhj.db;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 * Created by IntelliJ IDEA.
 * User: zhj
 * Date: 11-7-22
 * Time: 下午5:25
 * To change this template use File | Settings | File Templates.
 */
public class C3P0Test extends Thread {
    private static ComboPooledDataSource cpds;
    private static int threadNum;
    private static Logger logger = Logger.getLogger(C3P0Test.class);

    static {
        try {
            //Thread.sleep(20000);

        } catch (Exception e) {
            e.printStackTrace();
        }
        cpds = new ComboPooledDataSource();
        try {
            cpds.setDriverClass("oracle.jdbc.OracleDriver");
            cpds.setJdbcUrl("jdbc:oracle:thin:@10.4.247.92:1521:dev");
            cpds.setUser("carmot_sb_3");
            cpds.setPassword("carmot");
            //cpds.setMaxPoolSize(1);
            cpds.setInitialPoolSize(100);
            //cpds.setCheckoutTimeout(10000);
            //cpds.setUnreturnedConnectionTimeout(2);
            //cpds.setDebugUnreturnedConnectionStackTraces(true);
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public void run() {
        System.out.println("e");
        Connection con = null;
        Statement sm = null;
        try {
            // Thread.sleep(4000);
            con = cpds.getConnection();
            //  con.setAutoCommit(false);
            //Thread.sleep(5000);
            // for(int i=0;i<900;i++)  {
            sm = con.createStatement();
            ResultSet rs = sm.executeQuery("select * from tbuser where userid=1");
            //sm.close();
            while (rs.next()) {
                System.out.println(rs.getInt("userid"));
            }
            // }
            threadNum++;
            //if (threadNum <= 10)
            //System.out.println(1 / 0);
            //sm.close();
            //con=null;
            // con.commit();
            //Thread.sleep(10000);
            //con.close();;
            System.out.println(sm.isClosed());
            System.out.println(con.isClosed());
            con.close();
            System.out.println(sm.isClosed());
            System.out.println(con.isClosed());
        } catch (Exception e) {
            System.out.println("w");
            try {
                //sm.close();

                con.close();
            } catch (Exception e1) {
                e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        //  BasicConfigurator.configure();
        // logger.setLevel(Level.ERROR);
        // logger.error("insert error");

        System.out.println(threadNum);
    }

    public static void main(String[] args) {

        for (int i = 0; i < 0; i++) {

            new C3P0Test().start();
            System.out.println("i=" + i);
        }
        try {
            Thread.sleep(10);
            db();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void call(int i) {
        System.out.println(i);
    }

    public static void db() throws Exception {
        Class.forName("oracle.jdbc.OracleDriver");

        Connection conn = DriverManager.getConnection
                ("jdbc:oracle:thin:@10.4.247.92:1521:dev", "carmot_sb_3", "carmot");
        Statement stmt = null;
        // @//machineName:port/SID,   userid,  password
        try {
            conn.setAutoCommit(false);
            stmt = conn.createStatement();
            stmt.execute("insert into tt values(4)");
            //stmt.close();
             //System.out.println(1/0);
            conn.commit();
            System.out.println(conn.getAutoCommit());
        } catch (Exception ignore) {
                 conn.rollback();
            System.out.println(1);
        } finally {
            //System.out.println(stmt.isClosed());
            //System.out.println(conn.isClosed());
            conn.close();
            //System.out.println(stmt.isClosed());
            //System.out.println(conn.isClosed());
        }
    }
}

