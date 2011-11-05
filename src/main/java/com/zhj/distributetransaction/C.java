package com.zhj.distributetransaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by IntelliJ IDEA.
 * User: zhj
 * Date: 11-9-16
 * Time: 上午11:07
 * To change this template use File | Settings | File Templates.
 */
public class C {
    private Connection conn;
    {
        Connection conn=null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
            conn= DriverManager.getConnection("jdbc:oracle:thin:@10.4.247.92:1521:dev", "carmot_develop", "carmot");
        } catch (InstantiationException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IllegalAccessException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (ClassNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
