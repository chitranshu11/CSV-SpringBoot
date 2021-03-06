package com.chitranshu.saveo.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.chitranshu.saveo.json.response.MedicineDetailResponse;

public interface MedicineService {
	public boolean saveCSV(MultipartFile file);
	
	public List<String> searchMedicine(String name);

	public MedicineDetailResponse getMedicineDetails(String uniqueCode);
}
