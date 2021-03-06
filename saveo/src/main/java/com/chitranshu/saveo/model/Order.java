package com.chitranshu.saveo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="medicine_order")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderId;
	
	private String c_unique_id;
	private String c_name;
	private Long quantity;
	private Long medicineId;

	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public Long getMedicineId() {
		return medicineId;
	}
	public void setMedicineId(Long medicineId) {
		this.medicineId = medicineId;
	}
	public String getcUniqueCode() {
		return c_unique_id;
	}
	public void setcUniqueCode(String cUniqueCode) {
		this.c_unique_id = cUniqueCode;
	}
	public String getcName() {
		return c_name;
	}
	public void setcName(String cName) {
		this.c_name = cName;
	}
	public Long getnQuantity() {
		return quantity;
	}
	public void setnQuantity(Long nQuantity) {
		this.quantity = nQuantity;
	}
	
	
}
