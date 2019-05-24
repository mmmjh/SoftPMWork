package com.sql.bean;

public class MedicineBean {

	private int id;
	private int medicineId;
	private String medicineName;
	private int type;
	private int inventory;// 库存
	private String producer;// 生产商
	private float purchasingPrice;// 进价
	private float sellingPrice;// 卖价

	public MedicineBean() {
		super();
	}

	public MedicineBean(int id, int medicineId, String medicineName, int type, int inventory, String producer,
			float purchasingPrice, float sellingPrice) {
		super();
		this.id = id;
		this.medicineId = medicineId;
		this.medicineName = medicineName;
		this.type = type;
		this.inventory = inventory;
		this.producer = producer;
		this.purchasingPrice = purchasingPrice;
		this.sellingPrice = sellingPrice;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMedicineId() {
		return medicineId;
	}

	public void setMedicineId(int medicineId) {
		this.medicineId = medicineId;
	}

	public String getMedicineName() {
		return medicineName;
	}

	public void setMedicineName(String medicineName) {
		this.medicineName = medicineName;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getInventory() {
		return inventory;
	}

	public void setInventory(int inventory) {
		this.inventory = inventory;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public float getPurchasingPrice() {
		return purchasingPrice;
	}

	public void setPurchasingPrice(float purchasingPrice) {
		this.purchasingPrice = purchasingPrice;
	}

	public float getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(float sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

}
