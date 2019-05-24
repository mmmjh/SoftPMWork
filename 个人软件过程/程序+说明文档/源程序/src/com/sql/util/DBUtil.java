package com.sql.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 
public class DBUtil {
 
 // 创建一个数据库连接
    public static Connection getConnection()
    {
    	 Connection connection = null;
    	 String USERNAMR = "MJH";
         String PASSWORD = "123";//自己的密码
         String DRVIER = "oracle.jdbc.OracleDriver";
         String URL = "jdbc:Orac:thin:@localhost:1521:orcl";
        try {
        	System.out.println("尝试输出！");
            Class.forName(DRVIER);
            System.out.println("马佳慧无敌！");
            connection = DriverManager.getConnection(URL, USERNAMR, PASSWORD);
            System.out.println("成功连接数据库");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
  
        return connection;
    }
    //关闭资源
    public static void close(Statement state, Connection con) {
		if (state != null) {
			try {
				state.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (con != null)
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

	/**
	 * 关闭数据库的连接对象，SQL语句对象，查询结果集对象
	 * 
	 * @param rs
	 *            结果集对象
	 * @param state
	 *            Statement对象
	 * @param con
	 *            Connection对象
	 */
	public static void close(ResultSet rs, java.sql.Statement state, Connection con) {

		if (rs != null)
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if (state != null)
			try {
				state.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if (con != null)
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
 
}