package com.chitranshu.saveo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.chitranshu.saveo.json.response.MedicineDetailResponse;
import com.chitranshu.saveo.json.response.MedicineResponse;
import com.chitranshu.saveo.json.response.OrderResponse;
import com.chitranshu.saveo.model.Order;
import com.chitranshu.saveo.service.MedicineService;
import com.chitranshu.saveo.service.OrderService;

@RestController
public class MedicineContorller {
	@Autowired
	MedicineService medicineService;
	@Autowired
	OrderService orderService;

	@PostMapping(value = "/uploadCSV")
	public ResponseEntity<MedicineResponse> uploadCsv(@RequestParam("file") MultipartFile file) {
		MedicineResponse response = new MedicineResponse();

		if (file.isEmpty() || !file.getContentType().equals("text/csv")) {
			response.setMessage("Invalid File");
			response.setStatus(false);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
		if (medicineService.saveCSV(file)) {
			response.setMessage("Success : File uploaded");
			response.setStatus(true);
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}

		response.setMessage("Something Went Wrong");
		response.setStatus(false);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);

	}

	@GetMapping(value = "/searchMedicine")
	public ResponseEntity<List<String>> searchMedicine(@RequestParam String name) {
		List<String> names = medicineService.searchMedicine(name);

		return ResponseEntity.status(HttpStatus.OK).body(names);
	}

	@GetMapping(value = "/getMedicineDetails")
	public ResponseEntity<MedicineDetailResponse> getMedicineDetails(@RequestParam String c_unique_id) {

		MedicineDetailResponse response = medicineService.getMedicineDetails(c_unique_id);
		return ResponseEntity.status(HttpStatus.OK).body(response);

	}

	@PostMapping(value = "/placeorder")
	public ResponseEntity<OrderResponse> placeOrder(@RequestBody List<Order> orders) {
		Long id = orderService.placeOrder(orders);
		OrderResponse response = new OrderResponse();
		response.setUniqueId(id);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

}
