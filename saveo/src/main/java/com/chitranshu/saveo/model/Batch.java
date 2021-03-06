package com.chitranshu.saveo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="batch")
public class Batch {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long batchId;
	
	private String cBatchNo;
	private Long nBalanceQty;
	private String dExpiryDate;
	private String cSchemes;
	
	public Long getBatchId() {
		return batchId;
	}
	public void setBatchId(Long batchId) {
		this.batchId = batchId;
	}
	public String getcBatchNo() {
		return cBatchNo;
	}
	public void setcBatchNo(String cBatchNo) {
		this.cBatchNo = cBatchNo;
	}
	public Long getnBalanceQty() {
		return nBalanceQty;
	}
	public void setnBalanceQty(Long nBalanceQty) {
		this.nBalanceQty = nBalanceQty;
	}
	public String getdExpiryDate() {
		return dExpiryDate;
	}
	public void setdExpiryDate(String dExpiryDate) {
		this.dExpiryDate = dExpiryDate;
	}
	public String getcSchemes() {
		return cSchemes;
	}
	public void setcSchemes(String cSchemes) {
		this.cSchemes = cSchemes;
	}
	
	

}
