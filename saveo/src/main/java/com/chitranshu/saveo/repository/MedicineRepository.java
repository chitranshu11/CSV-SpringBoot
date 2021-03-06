package com.chitranshu.saveo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.chitranshu.saveo.model.Medicine;

public interface MedicineRepository extends JpaRepository<Medicine, Long>{
	
	
	
	@Query("Select c.cName from Medicine c where c.cName like %:name%")
	List<String> searchMedicineByName(String name);
	
	List<Medicine> findBycUniqueCode(String cUniqueCode);
	
	@Query("Select m FROM Medicine m where m.cName = :name and m.cUniqueCode = :code")
	List<Medicine> getMedicineByNameAndCode(String name, String code);


}