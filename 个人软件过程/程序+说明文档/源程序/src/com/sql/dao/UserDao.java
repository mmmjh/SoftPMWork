package com.sql.dao;



import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import com.sql.bean.UserBean;
import com.sql.util.DBUtil;

public class UserDao {

	public UserDao() {

	}

	// 删除个人信息
	public void delete(int id) {
		String sql = "delete from userinfor where userID =" + id;

		Connection con = DBUtil.getConnection();
		Statement state = null;
		try {
			state = con.createStatement();
			state.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(state, con);
		}
	}
	// 添加个人信息
	@SuppressWarnings("deprecation")
	public void add(UserBean userBean) {
		String sql =  "insert into userinfor(username,userpaw) values('" + ""
				+ userBean.getUsername() + "','" + userBean.getUserpaw()  + "')";
		System.out.println(new Date().toString() + "\t" + sql);
		Connection con = DBUtil.getConnection();
		Statement state = null;
		try {
			state = con.createStatement();
			state.execute(sql);		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(state, con);
		}
	}

	public int checkuser(String name,String password) throws Exception {
		Connection conn = DBUtil.getConnection();
		Statement st = null;
		ResultSet rs = null;

		try {
			st = conn.createStatement();
			String sql="select userpaw from userinfor where username='"+name+"'";
			rs = st.executeQuery(sql);
			System.out.println(sql);
			while (rs.next()) {
				
				if(rs.getInt(1)<=0)//>0说明数据库中bu存在该用户
				{
					//throw new Exception("用户不存在，请先注册！");
					return 0;//用户不存在
				}
				if (password.equals(rs.getString("userpaw")))
					return 1;//用户存在且密码正确
				else return 2;//密码不正确
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, st, conn);
		}
		return -1;
	}

}
