package com.chitranshu.saveo.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.chitranshu.saveo.json.response.MedicineDetailResponse;
import com.chitranshu.saveo.model.Batch;
import com.chitranshu.saveo.model.Medicine;
import com.chitranshu.saveo.repository.BatchRepository;
import com.chitranshu.saveo.repository.MedicineRepository;
import com.chitranshu.saveo.service.MedicineService;
import com.chitranshu.saveo.utility.CSVFileParseHelper;
import com.chitranshu.saveo.utility.MedicineHelper;

@Service
public class MedicineServiceImpl implements MedicineService {

	@Autowired
	MedicineRepository medicineRepository;
	@Autowired
	BatchRepository batchRepository;

	@Override
	public boolean saveCSV(MultipartFile file) {
		try {

			List<MedicineHelper> medicineList = CSVFileParseHelper.csvToMedicine(file.getInputStream());

			for (MedicineHelper helper : medicineList) {
				Batch batch = new Batch();
				batch.setcBatchNo(helper.getcBatchNo());
				batch.setcSchemes(helper.getcSchemes());
				batch.setdExpiryDate(helper.getdExpiryDate());
				batch.setnBalanceQty(helper.getnBalanceQty());

				batch = batchRepository.saveAndFlush(batch);

				Medicine medicine = new Medicine();

				medicine.setBatchId(batch.getBatchId());
				medicine.setcManufactures(helper.getcManufactures());
				medicine.setcName(helper.getcName());
				medicine.setcPackaging(helper.getcPackaging());
				medicine.setcUniqueCode(helper.getcUniqueCode());
				medicine.setHsnCode(helper.getHsnCode());
				medicine.setnMrp(helper.getnMrp());

				medicineRepository.saveAndFlush(medicine);
			}
			return true;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<String> searchMedicine(String name) {
		return medicineRepository.searchMedicineByName(name);
	}

	@Override
	public MedicineDetailResponse getMedicineDetails(String uniqueCode) {
		List<Medicine> medicines = medicineRepository.findBycUniqueCode(uniqueCode);
		MedicineDetailResponse response = new MedicineDetailResponse();
		
		Long totalQty = 0l;
		List<Batch> batches = new ArrayList<Batch>();
		for(Medicine medicine : medicines) {
			Batch  batch = batchRepository.findByBatchId(medicine.getBatchId());
			batches.add(batch);
			
			totalQty += batch.getnBalanceQty();
		}
		response.setMedicine(medicines.get(0));
		response.setTotalQuantity(totalQty);
		response.setBatches(batches);
	
		return response;
	}
}
