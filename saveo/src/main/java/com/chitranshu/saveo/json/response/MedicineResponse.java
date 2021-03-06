package com.chitranshu.saveo.json.response;

import java.util.List;

public class MedicineResponse {
	private boolean status;
	private String message;
	
	private List<String> medicineNames;
	
	
	public List<String> getMedicineNames() {
		return medicineNames;
	}
	public void setMedicineNames(List<String> medicineNames) {
		this.medicineNames = medicineNames;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String messgae) {
		this.message = messgae;
	}
	
}
