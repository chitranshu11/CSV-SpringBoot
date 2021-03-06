package com.chitranshu.saveo.json.response;

import java.util.List;

import com.chitranshu.saveo.model.Batch;
import com.chitranshu.saveo.model.Medicine;

public class MedicineDetailResponse {
	private Medicine medicine;
	private Long totalQuantity;
	private List<Batch> batches;
	
	
	
	public Long getTotalQuantity() {
		return totalQuantity;
	}
	public void setTotalQuantity(Long totalQuantity) {
		this.totalQuantity = totalQuantity;
	}
	public Medicine getMedicine() {
		return medicine;
	}
	public void setMedicine(Medicine medicine) {
		this.medicine = medicine;
	}
	public List<Batch> getBatches() {
		return batches;
	}
	public void setBatches(List<Batch> batches) {
		this.batches = batches;
	}
	
}
