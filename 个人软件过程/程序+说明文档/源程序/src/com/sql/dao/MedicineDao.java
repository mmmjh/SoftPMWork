package com.sql.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.sql.bean.MedicineBean;
import com.sql.bean.StaffBean;
import com.sql.util.DBUtil;

public class MedicineDao {

	public MedicineDao() {

	}

	// 删除药品信息
	public static void delete(int id) {
		String sql = "delete from medicine where id1 =" + id;

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

	// 更新药品信息
	public void update(int id,MedicineBean medicineBean) {
		String sql = "update medicine set medicineName='" + medicineBean.getMedicineName() + "', medicineId ='"
				+ medicineBean.getMedicineId() + "', medicinetype ='" + medicineBean.getType() + "', inventory ='"
				+ medicineBean.getInventory() + "', producer ='" + medicineBean.getProducer() + "', purchasingPrice ='"
				+ medicineBean.getPurchasingPrice() + "', sellingPrice ='" + medicineBean.getSellingPrice()
				+ "' where id1='" + id + "'";
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

	// 添加药品信息
	public void add(MedicineBean medicineBean) {
		String sql = "insert into medicine(medicineName,medicineId,medicinetype,inventory,producer,purchasingPrice,sellingPrice) values('"
				+ "" + medicineBean.getMedicineName() + "','" + medicineBean.getMedicineId() + "','"
				+ medicineBean.getType() + "','" + medicineBean.getInventory() + "','" + medicineBean.getProducer()
				+ "','" + medicineBean.getPurchasingPrice() + "','" + medicineBean.getSellingPrice() + "')";
		//System.out.println(new Date().toString() + "\t" + sql);
		Connection con = DBUtil.getConnection();
		Statement state = null;
		try {
			state = con.createStatement();
			state.execute(sql);
			//System.out.println(new Date().toString() + "\t" + medicineBean.getMedicineName() + "保存成功！");
		} catch (Exception e) {
			//System.out.println(new Date().toString() + "\t" + medicineBean.getMedicineName() + "保存失败！");
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
	
	public MedicineBean checkReg(int id) {
		Connection conn = DBUtil.getConnection();
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			statement = conn.createStatement();
			resultSet = statement.executeQuery("select * from medicine");
			while (resultSet.next()) {
				if (id == resultSet.getInt("id1")) {
					int medicineid = resultSet.getInt("medicineid");
					String medicinename=resultSet.getString("medicinename");
					int medicinetype = resultSet.getInt("medicinetype");
					int inventory = resultSet.getInt("inventory");
					String producer=resultSet.getString("producer");
				    float purchasingprice=resultSet.getFloat("purchasingprice");
					float sellingprice = resultSet.getFloat("sellingprice");
					MedicineBean medicineBean = new MedicineBean(id, medicineid, medicinename, medicinetype, inventory, producer, purchasingprice, sellingprice);
					return medicineBean;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(resultSet, statement, conn);
		}
		return null;
	}
	
	public boolean checkId(int id) {
		Connection conn = DBUtil.getConnection();
		Statement st = null;
		ResultSet rs = null;

		try {
			st = conn.createStatement();
			rs = st.executeQuery("select id1 from medicine ");
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

	/**
	 * 列出全部药品信息
	 * 
	 * @return
	 */
	public List<MedicineBean> getList() {
		System.out.println(new Date().toString() + "\tMeidcineDao.getList()执行开始！");
		String sql = "select * from medicine";

		Connection con = DBUtil.getConnection();
		Statement statement = null;
		ResultSet resultSet = null;
		List<MedicineBean> medicineBeans = new ArrayList<MedicineBean>();

		try {
			statement = con.createStatement();
			System.out.println(new Date().toString() + "\t执行：" + sql);
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				int id = resultSet.getInt("id1");
				String medicineName = resultSet.getString("medicineName");
				int medicineId = resultSet.getInt("medicineId");
				int type = resultSet.getInt("medicinetype");
				int inventory = resultSet.getInt("inventory");
				String producer = resultSet.getString("producer");
				float purchasingPrice = resultSet.getFloat("purchasingPrice");
				float sellingPrice = resultSet.getFloat("sellingPrice");
				medicineBeans.add(new MedicineBean(id, medicineId, medicineName, type, inventory, producer,
						purchasingPrice, sellingPrice));
			}
			System.out.println(new Date().toString() + "\t查询成功！查询结果" + medicineBeans.size());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(resultSet, statement, con);
		}
		return medicineBeans;
	}
}
