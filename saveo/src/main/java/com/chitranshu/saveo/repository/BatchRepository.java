package com.chitranshu.saveo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.chitranshu.saveo.model.Batch;

public interface BatchRepository extends JpaRepository<Batch, Long>{
	
	@Query("SELECT b FROM Batch b where b.batchId = :id")
	Batch findByBatchId(Long id);
}
