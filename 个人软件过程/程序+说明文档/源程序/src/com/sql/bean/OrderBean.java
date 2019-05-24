package com.sql.bean;

public class OrderBean {

	private int id;
	private int orderId;
	private int staffId;// 售货员
	private float money;
	private String createDate;// 日期
	private int paytype;// 付账类型

	public OrderBean() {
		super();
	}

	public OrderBean(int id, int orderId, int staffId, float money, String createDate, int paytype) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.staffId = staffId;
		this.money = money;
		this.createDate = createDate;
		this.paytype = paytype;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

	public float getMoney() {
		return money;
	}

	public void setMoney(float money) {
		this.money = money;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public int getPaytype() {
		return paytype;
	}

	public void setPaytype(int paytype) {
		this.paytype = paytype;
	}

}
