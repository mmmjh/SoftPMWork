package com.sql.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sql.util.Pager;
import com.sql.bean.StaffBean;
import com.sql.util.DBUtil;

public class StaffDao {

	public StaffDao() {

	}

	// 删除个人信息
	public void delete(int id) {
		String sql = "delete from staff where id1 =" + id;

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

	// 更新个人信息
	public void update(int id, StaffBean staffBean) {

		String sql = "update staff set staffName='" + staffBean.getStaffName() +"', born='"+staffBean.getBorn()+
				"',edu='"+staffBean.getEdu()+"',major='"+staffBean.getMajor()+"',degree1='"+staffBean.getDegree1()+
				"',loca='"+staffBean.getLoca()+"',email='"+staffBean.getEmail()+"',pict='"+
				staffBean.getPict()+"',nation='"+staffBean.getNation()+"', staffId='" + staffBean.getStaffId()
				+ "', sex='" + staffBean.getSex() + "', age='" + staffBean.getAge() + "', tel='" + staffBean.getCall()
				+ "', duty='" + staffBean.getDuty() + "', workingAge='" + staffBean.getWorkingAge() + "' where id1="
				+ id;
		System.out.println(sql);
		Connection con = DBUtil.getConnection();
		Statement st = null;
		try {
			st = con.createStatement();
			st.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(st, con);
		}
	}

	// 添加个人信息
	@SuppressWarnings("deprecation")
	public void add(StaffBean staffBean) {
		String sql = "insert into staff(staffName,staffId,sex,age,tel,duty,workingAge) values('" + ""
				+ staffBean.getStaffName() + "','" + staffBean.getStaffId() + "','" + staffBean.getSex() + "','"
				+ staffBean.getAge() + "','" + staffBean.getCall() + "','" + staffBean.getDuty() + "','"
				+ staffBean.getWorkingAge() + "')";
		System.out.println(new Date().toString() + "\t" + sql);
		Connection con = DBUtil.getConnection();
		Statement state = null;
		try {
			state = con.createStatement();
			state.execute(sql);
			System.out.println(new Date().toString() + "\t" + staffBean.getStaffName() + "保存成功！");
		} catch (Exception e) {
			System.out.println(new Date().toString() + "\t" + staffBean.getStaffName() + "保存失败！");
			e.printStackTrace();
		} finally {
			DBUtil.close(state, con);
		}
	}

	/**
	 * 检查该用户id是否已经存在，当用户注册的时候调用
	 * 
	 * @param name
	 *            用户名
	 * @return 如果用户名存在，返回false，否则返回true
	 */
	public StaffBean checkReg(int id) {
		Connection conn = DBUtil.getConnection();
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			statement = conn.createStatement();
			resultSet = statement.executeQuery("select * from staff");
			while (resultSet.next()) {
				if (id == resultSet.getInt("id1")) {
					String staffName = resultSet.getString("staffName");
					int staffId = resultSet.getInt("staffId");
					String sex = resultSet.getString("sex");
					int age = resultSet.getInt("age");
					String duty = resultSet.getString("duty");
					String call = resultSet.getString("tel");
					float workingAge = resultSet.getFloat("workingAge");
					String born = resultSet.getString("born");
					String nation = resultSet.getString("nation");
					String major = resultSet.getString("major");
					String edu = resultSet.getString("edu");
					String degree1 = resultSet.getString("degree1");
					String loca = resultSet.getString("loca");
					String email = resultSet.getString("email");
					String pict = resultSet.getString("pict");
					StaffBean staffBean = new StaffBean(id, staffId, staffName, sex, age, call, duty, workingAge,born,nation,major,edu,degree1,loca,email,pict);
					return staffBean;
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
	 * 检查该id是否已经存在，当用户注册的时候调用
	 * 
	 * @return 如果用户名存在，返回false，否则返回true
	 */
	public boolean checkId(int id) {
		Connection conn = DBUtil.getConnection();
		Statement st = null;
		ResultSet rs = null;

		try {
			st = conn.createStatement();
			rs = st.executeQuery("select id from staff ");
			while (rs.next()) {
				if (id == rs.getInt("id1"))
					return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, st, conn);
		}
		return true;
	}

	public boolean checkStaffId(int id) {
		Connection conn = DBUtil.getConnection();
		Statement st = null;
		ResultSet rs = null;

		try {
			st = conn.createStatement();
			rs = st.executeQuery("select staffId from staff ");
			while (rs.next()) {
				if (id == rs.getInt("id1"))
					return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, st, conn);
		}
		return true;
	}

	public List<StaffBean> getList() {
		String sql = "select * from staff";

		Connection con = DBUtil.getConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		List<StaffBean> staffBeans = new ArrayList<StaffBean>();

		try {
			statement = con.createStatement();
			System.out.println(new Date().toString() + "\t执行：" + sql);
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				int id = resultSet.getInt("id1");
				
				String staffName = resultSet.getString("staffName");
				int staffId = resultSet.getInt("staffId");
				String sex = resultSet.getString("sex");
				int age = resultSet.getInt("age");
				String duty = resultSet.getString("duty");
				String call = resultSet.getString("tel");
				float workingAge = resultSet.getFloat("workingAge");
				String born = resultSet.getString("born");
				String nation = resultSet.getString("nation");
				String major = resultSet.getString("major");
				String edu = resultSet.getString("edu");
				String degree1 = resultSet.getString("degree1");
				String loca = resultSet.getString("loca");
				String email = resultSet.getString("email");
				String pict = resultSet.getString("pict");
				staffBeans.add(new StaffBean(id, staffId, staffName, sex, age, call, duty, workingAge,born,nation,major,edu,degree1,loca,email,pict));
			}
			//System.out.println(new Date().toString() + "\t查询成功！查询结果" + staffBeans.size());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(resultSet, statement, con);
		}
		return staffBeans;
	}
	
	public Pager<StaffBean> load(String content, int pageIndex, int pageSize) {
		Pager<StaffBean> pager = new  Pager<StaffBean>();
		Connection connection = DBUtil.getConnection();
		//创建语句传输对象
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		//准备sql语句
		String sql = "select * from Staff ";
		//数据总条数
		String  sqlCount = "select count(*) from Staff";
		//集合中只能放入user对象
		List<StaffBean> users = new ArrayList<StaffBean>();
		StaffBean user = null;
		try {
			if (pageIndex <= 0) {
				pageIndex = 1;
			}			
			int start = (pageIndex-1)*pageSize;
			if (content == null || "".equals(content)) {
				sql += "";
			}else {
				sql += " where staffname like '%" + content +"%' or sex like '%" + content +"%'";
				sqlCount += " where staffname like '%" + content +"%' or sex like '%" + content +"%'";
				System.out.println(sqlCount);
			}
			System.out.println(sql);
			preparedStatement = connection.prepareStatement(sqlCount);
			resultSet = preparedStatement.executeQuery();			
			//总记录数
			int totalRecord = 0;
			while(resultSet.next()) {
				totalRecord = resultSet.getInt(1);//总行数
				System.out.println(totalRecord+"总条数");
			}	
			//总页数
			int totalPage = totalRecord%pageSize == 0 ? totalRecord/pageSize : totalRecord/pageSize + 1;
			if(content == null && "".equals(content))
				sql="select * from (select rownum as r,t.* from " + 
						"(select staff.* from staff  order by id1 asc) t where  rownum<="+(pageSize*pageIndex)
						+") where r>"+pageSize*(pageIndex-1);
			else
				 sql="select * from (select rownum as r,t.* from " + 
				"(select staff.* from staff where staffname like '%"+content +"%' order by id1 asc) t where  rownum<="+(pageSize*pageIndex)
				+") where r>"+pageSize*(pageIndex-1);
			
			System.out.println(sql);
			preparedStatement = connection.prepareStatement(sql);
			//preparedStatement.setInt(1, start);
			//preparedStatement.setInt(2, pageSize);
			resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				user = new StaffBean();
				user.setId(resultSet.getInt("id1"));
				user.setStaffId(resultSet.getInt("staffid"));
				user.setStaffName(resultSet.getString("staffname"));
				user.setSex(resultSet.getString("sex"));
				user.setAge(resultSet.getInt("age"));
				user.setCall(resultSet.getString("tel"));
				user.setDuty(resultSet.getString("duty"));
				user.setWorkingAge(resultSet.getFloat("workingage"));
				user.setBorn(resultSet.getString("born"));
				user.setNation(resultSet.getString("nation"));
				user.setEdu(resultSet.getString("edu"));
				user.setDegree1(resultSet.getString("degree1"));
				user.setMajor(resultSet.getString("major"));
				user.setLoca(resultSet.getString("loca"));
				user.setLoca(resultSet.getString("email"));
				users.add(user);
				
			}	
			//往分页对象里面设置数据
			pager.setDatas(users);
			pager.setPageIndex(pageIndex);
			pager.setPageSize(pageSize);
			pager.setTotalPage(totalPage);
			pager.setTotalRecord(totalRecord);
			System.out.println(user.getSex());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(resultSet, preparedStatement, connection);
		}
		return pager;
	}
	

}
