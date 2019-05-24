package com.sql.bean;

public class UserBean {

	private int userid;
	private String username;
	private String userpaw;

	public UserBean() {
		super();
	}

	public UserBean(int userid, String username,String userpaw) {
		super();
		this.userid = userid;
		this.username = username;
		this.userpaw = userpaw;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpaw() {
		return userpaw;
	}

	public void setUserpaw(String userpaw) {
		this.userpaw = userpaw;
	}

	
}
