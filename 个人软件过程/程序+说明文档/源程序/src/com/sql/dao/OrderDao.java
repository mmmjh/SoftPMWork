package com.sql.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sql.bean.OrderBean;
import com.sql.bean.StaffBean;
import com.sql.util.DBUtil;

public class OrderDao {

	public OrderDao() {

	}

	// 删除订单信息
	public void delete(int id) {
		String sql = "delete from order1 where id1 =" + id;

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

	// 更新订单信息
	public void update(int id,OrderBean orderBean) {
		String sql = "update order1 set orderId='" + orderBean.getOrderId() + "', staffId ='" + orderBean.getStaffId()
				+ "', money ='" + orderBean.getMoney() + "', createDate ='" + orderBean.getCreateDate()
				+ "', paytype ='" + orderBean.getPaytype() + "' where id1 ='" + id + "'";
		Connection con = DBUtil.getConnection();
		System.out.println(sql);
		Statement st = null;
		try {
			st = con.createStatement();
			st.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(st, con);
		}
	}

	// 添加订单信息
	public void add(OrderBean orderBean) {
		String sql = "insert into order1(orderId,staffId,money,createDate,paytype) values('" + ""
				+ orderBean.getOrderId() + "','" + orderBean.getStaffId() + "','" + orderBean.getMoney() + "','"
				+ orderBean.getCreateDate() + "','" + orderBean.getPaytype() + "')";
		System.out.println(sql);
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

	/**
	 * 检查该id是否已经存在
	 * 
	 * @return 如果id存在，返回false，否则返回true
	 */
	public boolean checkId(int id) {
		Connection conn = DBUtil.getConnection();
		Statement st = null;
		ResultSet rs = null;

		try {
			st = conn.createStatement();
			rs = st.executeQuery("select id1 from order1");
			while (rs.next()) {
				if (id == rs.getInt("id1"))
					System.out.println("成功找到");
					return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, st, conn);
		}
		System.out.println("mei找到");
		return true;
	}
	
	public OrderBean checkReg(int id) {
		Connection conn = DBUtil.getConnection();
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			statement = conn.createStatement();
			resultSet = statement.executeQuery("select * from order1");
			while (resultSet.next()) {
				if (id == resultSet.getInt("id1")) {
					int orderid = resultSet.getInt("orderid");
					int staffId = resultSet.getInt("staffId");
					float money = resultSet.getFloat("money");
					String createDate = resultSet.getString("createDate");
					int paytype=resultSet.getInt("paytype");
					OrderBean orderBean = new OrderBean(id,orderid,staffId,money,createDate,paytype);
					return orderBean;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(resultSet, statement, conn);
		}
		return null;
	}

	/**
	 * 列出全部订单信息
	 * 
	 * @return
	 */
	public List<OrderBean> getList() {
	//	System.out.println(new Date().toString() + "\tOrderDao.getList()执行开始！");
		String sql = "select * from order1";

		Connection con = DBUtil.getConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		List<OrderBean> orderBeans = new ArrayList<OrderBean>();

		try {
			statement = con.createStatement();
			//System.out.println(new Date().toString() + "\t执行：" + sql);
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				int id = resultSet.getInt("id1");
				int orderId = resultSet.getInt("orderId");
				int staffId = resultSet.getInt("staffId");
				float money = resultSet.getFloat("money");
				String createDate = resultSet.getString("createDate");
				int paytype = resultSet.getInt("paytype");
				orderBeans.add(new OrderBean(id, orderId, staffId, money, createDate, paytype));
			}
			System.out.println(new Date().toString() + "\t查询成功！查询结果" + orderBeans.size());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(resultSet, statement, con);
		}
		return orderBeans;
	}
}
