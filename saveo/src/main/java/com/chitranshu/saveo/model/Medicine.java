package com.chitranshu.saveo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="medicine")
public class Medicine {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long medicineId;
	
	private String cName;
	private String cPackaging;
	private String cUniqueCode;
	private String nMrp;
	private String cManufactures;
	private String hsnCode;
	private Long batchId;
	
	public Long getMedicineId() {
		return medicineId;
	}
	public void setMedicineId(Long medicineId) {
		this.medicineId = medicineId;
	}
	public Long getBatchId() {
		return batchId;
	}
	public void setBatchId(Long batchId) {
		this.batchId = batchId;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	
	public String getcPackaging() {
		return cPackaging;
	}
	public void setcPackaging(String cPackaging) {
		this.cPackaging = cPackaging;
	}
	public String getcUniqueCode() {
		return cUniqueCode;
	}
	public void setcUniqueCode(String cUniqueCode) {
		this.cUniqueCode = cUniqueCode;
	}

	public String getnMrp() {
		return nMrp;
	}
	public void setnMrp(String nMrp) {
		this.nMrp = nMrp;
	}
	public String getcManufactures() {
		return cManufactures;
	}
	public void setcManufactures(String cManufactures) {
		this.cManufactures = cManufactures;
	}
	public String getHsnCode() {
		return hsnCode;
	}
	public void setHsnCode(String hsnCode) {
		this.hsnCode = hsnCode;
	}
	
	

}
