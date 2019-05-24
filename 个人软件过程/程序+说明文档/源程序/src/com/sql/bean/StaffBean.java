package com.sql.bean;

public class StaffBean {

	private int id;
	private int staffId;
	private String staffName;
	private String sex;
	private int age;
	private String call;
	private String duty;// 职位
	private float workingAge;// 工龄
	private String born;//出生年月
	private String nation;//民族
	private String major;//专业
	private String edu;//学历
	private String degree1;//学位
	private String loca;//所在地区
	private String email;//所在地区
	private String pict;
	
	
	public String getPict() {
		return pict;
	}

	public void setPict(String pict) {
		this.pict = pict;
	}

	public StaffBean() {
		super();
	}

	public StaffBean(int id, int staffId, String staffName, String sex, int age, String call, String duty, float workingAge,String born,String nation,String major,String edu,String degree1,String loca,String email,String pict) {
		super();
		this.id = id;
		this.staffId = staffId;
		this.staffName = staffName;
		this.sex = sex;
		this.age = age;
		this.call = call;
		this.duty = duty;
		this.workingAge = workingAge;
		this.born = born;
		this.nation = nation;
		this.major = major;
		this.edu = edu;
		this.degree1 = degree1;
		this.loca = loca;
		this.email=email;
		this.pict=pict;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBorn() {
		return born;
	}

	public void setBorn(String born) {
		this.born = born;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getEdu() {
		return edu;
	}

	public void setEdu(String edu) {
		this.edu = edu;
	}

	public String getDegree1() {
		return degree1;
	}

	public void setDegree1(String degree1) {
		this.degree1 = degree1;
	}

	public String getLoca() {
		return loca;
	}

	public void setLoca(String loca) {
		this.loca = loca;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCall() {
		return call;
	}

	public void setCall(String call) {
		this.call = call;
	}

	public String getDuty() {
		return duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}

	public float getWorkingAge() {
		return workingAge;
	}

	public void setWorkingAge(float workingAge) {
		this.workingAge = workingAge;
	}

}
